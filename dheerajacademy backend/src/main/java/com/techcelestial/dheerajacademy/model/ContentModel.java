package com.techcelestial.dheerajacademy.model;


import javax.persistence.*;

@Entity
@Table(name = "contentMastertbl")
public class ContentModel {


    @Id
    @GeneratedValue
    @Column(name = "content_id")
    private Integer contentId;

    @Column(name = "content_Name")
    private String contentName;

    @Column(name = "status")
    private String status;


    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
