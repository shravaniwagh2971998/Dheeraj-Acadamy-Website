package com.techcelestial.dheerajacademy.controller;

import com.techcelestial.dheerajacademy.dto.*;
import com.techcelestial.dheerajacademy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/insertRegister",method = RequestMethod.POST)
    public ResponseVO insertRegisterRecord(@RequestBody LoginDto loginDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.insertRegisterCtrl(loginDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Register record inserted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Register record insertion failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/insertLogin",method = RequestMethod.POST)
    public ResponseVO<Login2Dto> insertLoginRecord(@RequestBody Login2Dto login2Dto)
    {
        ResponseVO<Login2Dto> responseVO=new ResponseVO();
       // Integer result=loginService.insertLoginCtrl(login2Dto);
        Login2Dto login2Dto1=loginService.insertLoginCtrl(login2Dto);

//        if(result==1)
//        {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
//            responseVO.setMessage("Login successfully");
//            responseVO.setResult(result);
//        }
//        if(result==2)
//        {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
//            responseVO.setMessage("Username incorrect");
//            responseVO.setResult(result);
//        }
//        if(result==3)
//        {
//            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
//            responseVO.setMessage("Password incorrect");
//            responseVO.setResult(result);
//        }
//        else if(result==5)
//        {
//            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
//            responseVO.setMessage("Username & Password incorrect");
//            responseVO.setResult(result);
//        }
//        return responseVO;
        if(login2Dto1!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("username return");
            responseVO.setResult(login2Dto1);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("username incorrect");
            responseVO.setResult(login2Dto1);
        }
        return responseVO;

    }

    @RequestMapping(value = "/forgotPassword",method = RequestMethod.POST)
    public ResponseVO insertNewPassword(@RequestBody ForgotDto forgotDto)
    {
        ResponseVO responseVO=new ResponseVO();
        Integer res=loginService.insertNewPass(forgotDto);

        if(res==1)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Password changed successfully");
            responseVO.setResult(res);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Password change failed");
            responseVO.setResult(res);
        }
        return responseVO;
    }

    @RequestMapping(value = "/insertProfile",method = RequestMethod.POST)
    public ResponseVO insertProfileDetails(@RequestBody ProfileDto profileDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.insertProfileCtrl(profileDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Profile Uploaded successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Profile failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getProfile",method = RequestMethod.GET)
    public ResponseVO getProfileDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=loginService.getProfileCtrl();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Profile got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Profile failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "/editProfileDetails/{profileId}",method = RequestMethod.POST)
    public ResponseVO editProfileRecord(@PathVariable Integer profileId)
    {
        ResponseVO responseVO=new ResponseVO();
        ProfileDto profileDto=loginService.editProfileCtrl(profileId);

        if(profileDto!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Edit profile record successfully");
            responseVO.setResult(profileDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Edit profile record failed");
            responseVO.setResult(profileDto);
        }
        return responseVO;
    }

    @RequestMapping(value = "/updateProfile",method = RequestMethod.POST)
    public ResponseVO updateProfileDetails(@RequestBody ProfileDto profileDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.updateProfileCtrl(profileDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Profile Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Profile update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/deleteProfile/{profileId}",method = RequestMethod.DELETE)
    public ResponseVO deleteProfileDetails(@PathVariable Integer profileId)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.deleteProfileCtrl(profileId);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Profile record deleted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Profile record not deleted");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getRegistration",method = RequestMethod.GET)
    public ResponseVO getRegistrationDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List registrationList=loginService.getRegistrationRecordController();

        if(registrationList!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Registration record got successfully");
            responseVO.setResult(registrationList);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Registration record failed");
            responseVO.setResult(registrationList);
        }
        return responseVO;
    }

    @RequestMapping(value = "/editRegistrationDetails/{loginId}",method = RequestMethod.POST)
    public ResponseVO editRegistrationRecord(@PathVariable Integer loginId)
    {
        ResponseVO responseVO=new ResponseVO();
        LoginDto loginDto=loginService.editRegistrationCtrl(loginId);

        if(loginDto!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Edit Registration record successfully");
            responseVO.setResult(loginDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Edit Registration record failed");
            responseVO.setResult(loginDto);
        }
        return responseVO;
    }

    @RequestMapping(value = "/updateRegistration",method = RequestMethod.POST)
    public ResponseVO updateRegistrationDetails(@RequestBody LoginDto loginDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.updateRegistrationCtrl(loginDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Registration Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Registration update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/deleteRegistration/{loginId}",method = RequestMethod.DELETE)
    public ResponseVO deleteRegistrationDetails(@PathVariable Integer loginId)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.deleteRegistrationCtrl(loginId);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Registration record deleted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Registration record not deleted");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/insertAddressDetails",method = RequestMethod.POST)
    public ResponseVO insertAddress(@RequestBody AddressDto addressDto )
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.insertAddressCtrl(addressDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Address inserted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Address insertion failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getAddress",method = RequestMethod.GET)
    public ResponseVO getAddressDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=loginService.getAddressCtrl();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Address got successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Address failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "/editAddressDetails/{addressId}",method = RequestMethod.POST)
    public ResponseVO editAddressRecord(@PathVariable Integer addressId)
    {
        ResponseVO responseVO=new ResponseVO();
        AddressDto addressDto=loginService.editAddressCtrl(addressId);

        if(addressDto!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Edit Address record successfully");
            responseVO.setResult(addressDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Edit Address record failed");
            responseVO.setResult(addressDto);
        }
        return responseVO;
    }

    @RequestMapping(value = "/updateAddress",method = RequestMethod.POST)
    public ResponseVO updateAddressDetails(@RequestBody AddressDto addressDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.updateAddressCtrl(addressDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Address Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Address update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/deleteAddress/{addressId}",method = RequestMethod.DELETE)
    public ResponseVO deleteAddressDetails(@PathVariable Integer addressId)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.deleteAddressCtrl(addressId);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Address record deleted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Address record not deleted");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/insertImageStatusDetails",method = RequestMethod.POST)
    public ResponseVO insertImageStatus(@RequestBody ActiveImageDto activeImageDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.insertImageWiseStatuseService(activeImageDto);

        //System.out.println("In Controller");

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Insert successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage(" insertion failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "/getImageDisplay",method = RequestMethod.GET)
    public ResponseVO getImageDisplayDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=loginService.getImageController();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("user failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "/editImage/{imageId}",method = RequestMethod.POST)
    public ResponseVO editImageRecord(@PathVariable Integer imageId)
    {
        ResponseVO responseVO=new ResponseVO();
        ActiveImageDto activeImageDto=loginService.editImageCtrl(imageId);

        if(activeImageDto!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Edit record successfully");
            responseVO.setResult(activeImageDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Edit record failed");
            responseVO.setResult(activeImageDto);
        }
        return responseVO;
    }

    @RequestMapping(value = "/updateImage",method = RequestMethod.POST)
    public ResponseVO updateImageDetails(@RequestBody ActiveImageDto activeImageDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.updateImageCtrl(activeImageDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("status Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("status update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    //    Prajakta
    @RequestMapping(value = "/getActiveStatusImageDisplay",method = RequestMethod.GET)
    public ResponseVO getActiveStatusImageDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=loginService.getActiveImageController();

        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get image successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("get failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }



    //    Gallery
    @RequestMapping(value = "InsertGalleryImages",method = RequestMethod.POST)
    public ResponseVO insertGalleryImageDetails(@RequestBody GalleryDto galleryDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.insertGalleryController(galleryDto);
        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("image inserted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Insertion failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }
    @RequestMapping(value = "getGalleryImages",method = RequestMethod.GET)
    public ResponseVO getGalleryImagedetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=loginService.getGalleryImageController();
        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("image get successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("get failed");
            responseVO.setResult(list);
        }
        return responseVO;

    }
    @RequestMapping(value = "/editGalleryDetails/{galleryId}",method = RequestMethod.POST)
    public ResponseVO editGalleryRecord(@PathVariable Integer galleryId)
    {
        ResponseVO responseVO=new ResponseVO();
        GalleryDto galleryDto=loginService.editGalleryCtrl(galleryId);

        if(galleryDto!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Edit record successfully");
            responseVO.setResult(galleryDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Edit record failed");
            responseVO.setResult(galleryDto);
        }
        return responseVO;
    }

    @RequestMapping(value = "/updateGallery",method = RequestMethod.POST)
    public ResponseVO updateGalleryDetails(@RequestBody GalleryDto galleryDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.updateGalleryCtrl(galleryDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("status Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("status update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }

    @RequestMapping(value = "getActiveGalleryImages",method =RequestMethod.GET)
    public ResponseVO getActiveGalleryDetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=loginService.getActiveGalleryImageController();
        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("active image get successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("get failed");
            responseVO.setResult(list);
        }
        return responseVO;
    }



//    Content Form


    @RequestMapping(value = "InsertContentData",method = RequestMethod.POST)
    public ResponseVO insertContentDetails(@RequestBody ContentDto contentDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.insertContentController(contentDto);
        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("image inserted successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Insertion failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }
    @RequestMapping(value = "getContentData",method = RequestMethod.GET)
    public ResponseVO getContentdetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=loginService.getContentController();
        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("image get successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("get failed");
            responseVO.setResult(list);
        }
        return responseVO;

    }
    @RequestMapping(value = "/editContentDetails/{contentId}",method = RequestMethod.POST)
    public ResponseVO editContentRecord(@PathVariable Integer contentId)
    {
        ResponseVO responseVO=new ResponseVO();
        ContentDto contentDto=loginService.editContentCtrl(contentId);

        if(contentDto!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("Edit record successfully");
            responseVO.setResult(contentDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Edit record failed");
            responseVO.setResult(contentDto);
        }
        return responseVO;
    }

    @RequestMapping(value = "/updateContent",method = RequestMethod.POST)
    public ResponseVO updateContentDetails(@RequestBody ContentDto contentDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=loginService.updateContentCtrl(contentDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("status Updated successfully");
            responseVO.setResult(flag);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("status update failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }



    @RequestMapping(value = "getActiveContentData",method = RequestMethod.GET)
    public ResponseVO getActiveContentdetails()
    {
        ResponseVO responseVO=new ResponseVO();
        List list=loginService.getActiveContentController();
        if(list!=null)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("image get successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("get failed");
            responseVO.setResult(list);
        }
        return responseVO;

    }




}

