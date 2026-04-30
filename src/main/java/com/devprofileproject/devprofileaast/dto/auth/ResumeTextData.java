package com.devprofileproject.devprofileaast.dto.auth;

//Dto integration
public record ResumeTextData(
        String originalFilename, Long fileSize,
        String filePath, String extractedText) {
}
