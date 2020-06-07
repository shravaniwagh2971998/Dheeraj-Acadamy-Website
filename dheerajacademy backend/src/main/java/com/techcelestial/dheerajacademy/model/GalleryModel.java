package com.techcelestial.dheerajacademy.model;


import javax.persistence.*;

@Entity
@Table(name = "gallery_tbl")
public class GalleryModel {
    @Id
    @GeneratedValue
    @Column(name = "gallery_id")
    private Integer galleryId;

    @Column(name = "gallery_Name")
    private String galleryName;

    @Column(name = "status")
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
