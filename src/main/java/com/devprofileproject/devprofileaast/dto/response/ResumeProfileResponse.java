package com.devprofileproject.devprofileaast.dto.response;

public class ResumeProfileResponse {
    private String orginalFilename;
    private Long fileSize;
    private String extractedTextPreview;
    private int extractedTextLength;
    private int uploadedAt;

    public ResumeProfileResponse(String orginalFilename, Long fileSize, String extractedTextPreview,
            int extractedTextLength, int uploadedAt) {
        this.orginalFilename = orginalFilename;
        this.fileSize = fileSize;
        this.extractedTextPreview = extractedTextPreview;
        this.extractedTextLength = extractedTextLength;
        this.uploadedAt = uploadedAt;
    }

    public String getOrginalFilename() {
        return orginalFilename;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public String getExtractedTextPreview() {
        return extractedTextPreview;
    }

    public int getExtractedTextLength() {
        return extractedTextLength;
    }

    public int getUploadedAt() {
        return uploadedAt;
    }

}
