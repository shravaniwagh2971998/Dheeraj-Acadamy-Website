package com.techcelestial.dheerajacademy.controller;

import com.amazonaws.AmazonClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
public class AwsController {
    @Autowired
    private AmazonClient  amazonClient;

    public void setAmazonClient(AmazonClient amazonClient)
    {
        this.amazonClient = amazonClient;
    }



    /*@RequestMapping(value = "/uploadLogo",method = RequestMethod.POST)
        public String uploadLogoCtrl(@RequestParam(value = "uploadlogo") MultipartFile file) {
        String str= this.amazonClient.uploadLogo(file);
        System.out.print("url"+str);
        return  str;
        }
        */
    @RequestMapping(value = "/uploadProfile",method = RequestMethod.POST)
    public String uploadprofileCtrl(@RequestParam(value = "uploadfile") MultipartFile file) {
        String str= this.amazonClient.uploadprofile(file);
        System.out.print("url"+str);
        return  str;
    }
    

}

