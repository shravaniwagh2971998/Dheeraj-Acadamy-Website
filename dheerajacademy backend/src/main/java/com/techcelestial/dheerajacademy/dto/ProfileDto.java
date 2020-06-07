package com.techcelestial.dheerajacademy.dto;

public class ProfileDto {
    private Integer profileId;
    private String profileImg;
    private String profileName;
    private String profileQualification;
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
