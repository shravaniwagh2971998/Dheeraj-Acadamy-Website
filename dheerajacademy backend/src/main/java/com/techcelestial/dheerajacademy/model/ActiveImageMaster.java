package com.techcelestial.dheerajacademy.model;


import javax.persistence.*;

@Entity
@Table(name = "active_image_tbl")
public class ActiveImageMaster {

    @Id
    @GeneratedValue
    @Column(name = "imageId")
    private Integer imageId;


    @Column(name = "home_page_img")
    private String homePageImg;


    @Column(name = "status")
    private String status;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getHomePageImg() {
        return homePageImg;
    }

    public void setHomePageImg(String homePageImg) {
        this.homePageImg = homePageImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
