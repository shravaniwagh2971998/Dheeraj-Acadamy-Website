package com.techcelestial.dheerajacademy.controller;

import com.techcelestial.dheerajacademy.dto.ResponseVO;
import com.techcelestial.dheerajacademy.dto.WebEnquiryDto;
import com.techcelestial.dheerajacademy.service.WebEnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WebEnquiryController {
    @Autowired
    private WebEnquiryService webEnquiryService;

    @PostMapping(value="/webenquiry")
    public ResponseVO addEnquiry(@RequestBody WebEnquiryDto webEnquiryDto){
        ResponseVO responseVO=new ResponseVO<>();
        System.out.println("hello");
        boolean flag=webEnquiryService.addEnquiry(webEnquiryDto);
        if(flag){
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Insert Successfully!!");
            responseVO.setResult(webEnquiryDto);

        }
        else{
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Insert Failed!!");
            responseVO.setResult(webEnquiryDto);
        }
        return responseVO;
    }



    @GetMapping(value = "/webenquiry")
    public ResponseVO getWebEnquiry(){

        ResponseVO response=new ResponseVO();
        List list=webEnquiryService.getWebEnquiry();
        //System.out.println("date"+list);
        response.setResult(list);
        return response;

    }

    @RequestMapping(value = "/deleteContact/{wenEnquiryId}",method = RequestMethod.DELETE)
    public ResponseVO deleteContactDetails(@PathVariable Integer wenEnquiryId)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=webEnquiryService.deleteContactCtrl(wenEnquiryId);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Contact record deleted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Contact record not deleted");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

}
