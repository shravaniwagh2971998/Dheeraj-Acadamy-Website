package com.techcelestial.dheerajacademy.service;

import com.techcelestial.dheerajacademy.dto.WebEnquiryDto;

import java.util.List;

public interface WebEnquiryService {
    boolean addEnquiry(WebEnquiryDto webEnquiryDto);

    List getWebEnquiry();

    boolean deleteContactCtrl(Integer wenEnquiryId);
}
