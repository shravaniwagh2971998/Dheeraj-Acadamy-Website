package com.techcelestial.dheerajacademy.dto;

public class GalleryDto {
    private Integer galleryId;
    private String galleryName;
    private String status;
    public Integer getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(Integer galleryId) {
        this.galleryId = galleryId;
    }

    public String getGalleryName() {
        return galleryName;
    }

    public void setGalleryName(String galleryName) {
        this.galleryName = galleryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
