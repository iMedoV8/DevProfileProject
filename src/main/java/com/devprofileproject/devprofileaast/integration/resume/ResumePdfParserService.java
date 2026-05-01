package com.devprofileproject.devprofileaast.integration.resume;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devprofileproject.devprofileaast.exception.ResumeParsingException;



@Service
public class ResumePdfParserService {

    private static final int MAX_TEXT_LENGTH = 20_000;

    private final String storagePath;

    public ResumePdfParserService(@Value("${resume.storage.path:storage/resumes}") String storagePath) {
        this.storagePath = storagePath;
    }

    public ResumeTextData extractText(Long sessionId, MultipartFile file) {

        if (file.isEmpty()) {
            throw new ResumeParsingException("Uploaded file is empty");
        }

        byte[] fileBytes;
        try {
            fileBytes = file.getBytes();
        } catch (IOException ex) {
            throw new ResumeParsingException("Failed to read uploaded file: " + ex.getMessage(), ex);
        }

        String extractedText;
        try (PDDocument document = Loader.loadPDF(fileBytes)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            if (text == null || text.isBlank()) {
                throw new ResumeParsingException(
                        "Could not extract text from PDF. The file may be image-based or corrupted.");
            }

            extractedText = text.strip();
            if (extractedText.length() > MAX_TEXT_LENGTH) {
                extractedText = extractedText.substring(0, MAX_TEXT_LENGTH);
            }

        } catch (ResumeParsingException ex) {
            throw ex;
        } catch (IOException ex) {
            throw new ResumeParsingException("Failed to parse PDF file: " + ex.getMessage(), ex);
        }

        String filePath = saveFileToDisk(sessionId, fileBytes);

        return new ResumeTextData(
                file.getOriginalFilename(),
                file.getSize(),
                filePath,
                extractedText);
    }

    private String saveFileToDisk(Long sessionId, byte[] fileBytes) {

        try {
            Path directory = Paths.get(storagePath);
            Files.createDirectories(directory);

            String filename = sessionId + ".pdf";
            Path targetPath = directory.resolve(filename);
            Files.write(targetPath, fileBytes);

            return targetPath.toString();

        } catch (IOException ex) {
            throw new ResumeParsingException("Failed to save resume file: " + ex.getMessage(), ex);
        }
    }
}
