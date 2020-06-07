package com.techcelestial.dheerajacademy.dao;

import com.techcelestial.dheerajacademy.model.WebEnquiry;

import java.util.List;

public interface WebEnquiryDao {
    boolean addEnquiry(WebEnquiry webEnquiry);

    List getWebEnquiry();

    boolean deleteContact(Integer wenEnquiryId);
}
