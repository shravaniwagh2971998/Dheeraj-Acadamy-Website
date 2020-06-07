package com.techcelestial.dheerajacademy.model;

import javax.persistence.*;

@Entity
@Table(name = "ProfileMaster")
public class ProfileModel {
    @Id
    @GeneratedValue
    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "profile_img")
    private String profileImg;

    @Column(name = "profile_name")
    private String profileName;

    @Column(name = "profile_qualification")
    private String profileQualification;

    @Column(name = "profile_status")
    private String status;


    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileQualification() {
        return profileQualification;
    }

    public void setProfileQualification(String profileQualification) {
        this.profileQualification = profileQualification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
