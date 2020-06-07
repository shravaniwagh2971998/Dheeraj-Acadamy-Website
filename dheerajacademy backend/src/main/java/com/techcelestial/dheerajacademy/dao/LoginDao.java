package com.techcelestial.dheerajacademy.dao;

import com.techcelestial.dheerajacademy.dto.*;
import com.techcelestial.dheerajacademy.model.*;

import java.util.List;

public interface LoginDao {
    boolean insertRegisterRecord(LoginModel loginModel);

    List<LoginModel> getLoginRecord();

    boolean insertProfileDetails(ProfileModel profileModel);

    List getProfileDetails();

    boolean insertNewPassword(ForgotModel forgotModel);


    Integer getUpdateInfo(LoginModel loginModel);

    ProfileDto editProfile(Integer profileId);

    boolean updateProfileDetails(ProfileModel profileModel);

    boolean deleteProfile(Integer profileId);

    List getRegistrationDetails();

    LoginDto editRegistration(Integer loginId);

    boolean updateRegistrationRecord(LoginModel loginModel);

    boolean deleteRegistrationRecord(Integer loginId);

    String getUsername(String username);

    String getPass(String password);

    boolean insertAddress(AddressModel addressModel);

    List getAddressDetails();

    AddressDto editAddress(Integer addressId);

    boolean updateAddressRecord(AddressModel addressModel);

    boolean deleteAddressRecord(Integer addressId);



    boolean insertStatusDao(ActiveImageMaster activeImageMaster);

    List getImageService();

    ActiveImageDto editImageStatus(Integer imageId);



    boolean updateImageStatusDao(ActiveImageMaster activeImageMaster);

    List getActiveStatusImageService();

    boolean insertGalleryService(GalleryModel galleryModel);

    List getGalleryService();

    GalleryDto editGalleryStatus(Integer galleryId);

    boolean updateGalleryService(GalleryModel galleryModel);

    List getActiveGalleryService();

    boolean insertContentService(ContentModel contentModel);

    List getContentService();

    ContentDto editContentStatus(Integer contentId);

    boolean updateContentService(ContentModel contentModel);

    List getActiveContentService();



}
