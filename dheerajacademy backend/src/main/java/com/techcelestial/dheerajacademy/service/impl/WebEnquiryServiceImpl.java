package com.techcelestial.dheerajacademy.service.impl;

import com.techcelestial.dheerajacademy.dao.WebEnquiryDao;
import com.techcelestial.dheerajacademy.dto.WebEnquiryDto;
import com.techcelestial.dheerajacademy.model.WebEnquiry;
import com.techcelestial.dheerajacademy.service.WebEnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WebEnquiryServiceImpl implements WebEnquiryService {
    @Autowired
    private WebEnquiryDao webEnquiryDao;


    @Override
    public boolean addEnquiry(WebEnquiryDto webEnquiryDto) {
        WebEnquiry webEnquiry =new WebEnquiry();
        webEnquiry.setEmail(webEnquiryDto.getEmail());
        webEnquiry.setMessasge(webEnquiryDto.getMessasge());
        webEnquiry.setDate(new Date());
        webEnquiry.setContact(webEnquiryDto.getContact());
        return webEnquiryDao.addEnquiry(webEnquiry);
    }

    @Override
    public List getWebEnquiry() {

        return webEnquiryDao.getWebEnquiry();
    }

    @Override
    public boolean deleteContactCtrl(Integer wenEnquiryId)
    {
        boolean flag=webEnquiryDao.deleteContact(wenEnquiryId);
        return flag;
    }
}
