package com.techcelestial.dheerajacademy.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="web_enquiry")
public class WebEnquiry
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer wenEnquiryId;
    @Column
    private String email;
    @Column
    private String messasge;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
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
