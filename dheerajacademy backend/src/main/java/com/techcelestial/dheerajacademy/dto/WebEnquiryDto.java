package com.techcelestial.dheerajacademy.dto;

import javax.persistence.Column;
import java.util.Date;

public class WebEnquiryDto {
    private Integer wenEnquiryId;
    private String email;
    private String messasge;
    private Date date;
    private String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getWenEnquiryId() {
        return wenEnquiryId;
    }

    public void setWenEnquiryId(Integer wenEnquiryId) {
        this.wenEnquiryId = wenEnquiryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessasge() {
        return messasge;
    }

    public void setMessasge(String messasge) {
        this.messasge = messasge;
    }
}
