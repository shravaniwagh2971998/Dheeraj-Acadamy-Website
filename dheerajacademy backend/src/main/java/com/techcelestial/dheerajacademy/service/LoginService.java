package com.techcelestial.dheerajacademy.service;

import com.techcelestial.dheerajacademy.dto.*;

import java.util.List;

public interface LoginService {
    boolean insertRegisterCtrl(LoginDto loginDto);

  //  Integer insertLoginCtrl(Login2Dto login2Dto);
    Login2Dto insertLoginCtrl(Login2Dto login2Dto);
    boolean insertProfileCtrl(ProfileDto profileDto);

    List getProfileCtrl();

    Integer insertNewPass(ForgotDto forgotDto);

    ProfileDto editProfileCtrl(Integer profileId);

    boolean updateProfileCtrl(ProfileDto profileDto);

    boolean deleteProfileCtrl(Integer profileId);

    List getRegistrationRecordController();

    LoginDto editRegistrationCtrl(Integer loginId);

    boolean updateRegistrationCtrl(LoginDto loginDto);

    boolean deleteRegistrationCtrl(Integer loginId);

  boolean insertAddressCtrl(AddressDto addressDto);

  List getAddressCtrl();

  AddressDto editAddressCtrl(Integer addressId);

  boolean updateAddressCtrl(AddressDto addressDto);

  boolean deleteAddressCtrl(Integer addressId);

  boolean insertImageWiseStatuseService(ActiveImageDto activeImageDto);

  List getImageController();

  ActiveImageDto editImageCtrl(Integer imageId);

  boolean updateImageCtrl(ActiveImageDto activeImageDto);

  List getActiveImageController();

  boolean insertGalleryController(GalleryDto galleryDto);



  List getGalleryImageController();

  GalleryDto editGalleryCtrl(Integer galleryId);

  boolean updateGalleryCtrl(GalleryDto galleryDto);

  List getActiveGalleryImageController();

  boolean insertContentController(ContentDto contentDto);

  List getContentController();

  ContentDto editContentCtrl(Integer contentId);

  boolean updateContentCtrl(ContentDto contentDto);

  List getActiveContentController();



}
