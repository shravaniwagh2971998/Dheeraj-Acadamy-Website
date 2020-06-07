package com.techcelestial.dheerajacademy.service.impl;

import com.techcelestial.dheerajacademy.dao.LoginDao;
import com.techcelestial.dheerajacademy.dto.*;
import com.techcelestial.dheerajacademy.model.*;
import com.techcelestial.dheerajacademy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public boolean insertRegisterCtrl(LoginDto loginDto)
    {
        LoginModel loginModel=new LoginModel();

        loginModel.setName(loginDto.getName());
        loginModel.setUsername(loginDto.getUsername());
        loginModel.setPassword(loginDto.getPassword());
        loginModel.setRepeatPassword(loginDto.getRepeatPassword());
        loginModel.setStatus(loginDto.getStatus());

        boolean flag=loginDao.insertRegisterRecord(loginModel);

        return flag;
    }

//    @Override
//    public Integer insertLoginCtrl(Login2Dto login2Dto)
//    {
//        List<LoginModel> loginModellist =loginDao.getLoginRecord();
//        System.out.println("Registration List="+loginModellist.size());
//
//        for(LoginModel loginModel:loginModellist)
//        {
//            if(loginModel.getStatus().equals("active"))
//            {
//                if (login2Dto.getUsername() != null && login2Dto.getPassword() != null)
//                {
//                    if (login2Dto.getUsername().equals(loginModel.getUsername()) && login2Dto.getPassword().equals(loginModel.getPassword())) {
//                        return 1;
//                    } else if (!(login2Dto.getUsername() == (loginModel.getUsername())) && login2Dto.getPassword().equals(loginModel.getPassword())) {
//                        return 2;
//                    } else if (login2Dto.getUsername().equals(loginModel.getUsername()) && !(login2Dto.getPassword() == (loginModel.getPassword()))) {
//                        return 3;
//                    }
//                }
//            }
//        }
//        return 5;
//    }
    @Override
    public Login2Dto insertLoginCtrl(Login2Dto login2Dto)
    {
          //  List<LoginModel> list1=new ArrayList<LoginModel>();
           String username=loginDao.getUsername(login2Dto.getUsername());
            System.out.println("query username:"+username);

            Login2Dto login2Dto1=new Login2Dto();
           // login2Dto1.setUsername("priya");
           // login2Dto1.setPassword("priya");
            if(username==null)
            {
                login2Dto1.setUsername("inactiveUser");
                return login2Dto1;
            }
        String password1=loginDao.getPass(login2Dto.getPassword());
            System.out.println("query passw:"+password1);

            if(password1==null)
            {
                login2Dto1.setPassword("inactivePass");
                return login2Dto1;
            }
        if (username != null && password1!=null ) {
            if (login2Dto.getUsername() != null && login2Dto.getPassword()!=null) {
                       if (login2Dto.getUsername().equals(username) && login2Dto.getPassword().equals(password1)) {

                           login2Dto.setUsername(username);
                          login2Dto.setPassword(password1);

                           System.out.println("username:"+username);

                           System.out.println("password1:"+password1);
                           return login2Dto;
                       }
                   }
        }

//            Login2Dto login2Dto1=new Login2Dto();
//
//            login2Dto1.setUsername("admin");
//            login2Dto1.setPassword("admin password");
//
//            String password1=loginDao.getPass(login2Dto.getPassword());
//            System.out.println("query passw"+password1);
//
//            if (username != null && password1!=null ) {
//                   if (login2Dto.getUsername() != null && login2Dto.getPassword()!=null) {
//                       if (login2Dto.getUsername().equals(username) && login2Dto.getPassword().equals(password1)) {
//
//                           login2Dto.setUsername(username);
//                          login2Dto.setPassword(password1);
//
//                           System.out.println("username"+username);
//
//                           System.out.println("password1"+password1);
//                           return login2Dto;
//                       }
//                   }
//               }
//               else
//            {
//                 login2Dto.setUsername("shravani");
//                 login2Dto.setPassword("123");
//
//                 return login2Dto;
//            }

        return login2Dto1;
    }

    @Override
    public boolean insertProfileCtrl(ProfileDto profileDto)
    {
        ProfileModel profileModel=new ProfileModel();

        profileModel.setProfileImg(profileDto.getProfileImg());
        profileModel.setProfileName(profileDto.getProfileName());
        profileModel.setProfileQualification(profileDto.getProfileQualification());
        profileModel.setStatus(profileDto.getStatus());

        boolean flag=loginDao.insertProfileDetails(profileModel);
        return flag;

    }

    @Override
    public List getProfileCtrl()
    {
        List list=loginDao.getProfileDetails();


        System.out.println("profile list size:"+list.size());
        return list;
    }

    @Override
    public Integer insertNewPass(ForgotDto forgotDto)
    {
        List<LoginModel> loginModellist = loginDao.getLoginRecord();
        System.out.println("Registration List=" + loginModellist.size());

        for (LoginModel loginModel : loginModellist) //registration list
        {
//            System.out.println("forgot username:"+forgotDto.getForgotUsername());
//            System.out.println("login username:"+loginModel.getUsername());

            if(forgotDto.getForgotUsername().equals(loginModel.getUsername()))
            {

                loginModel.setLoginId(loginModel.getLoginId());
                loginModel.setUsername(forgotDto.getForgotUsername());
                loginModel.setPassword(forgotDto.getForgotPassword());
                loginModel.setRepeatPassword(forgotDto.getForgotConpassword());

                Integer res=loginDao.getUpdateInfo(loginModel);
                return res;

            }
            else
            {
                System.out.println("data not updated");
            }
        }
        return 5;
    }

    @Override
    public ProfileDto editProfileCtrl(Integer profileId)
    {
        ProfileDto profileDto=loginDao.editProfile(profileId);
        return profileDto;
    }

    @Override
    public boolean updateProfileCtrl(ProfileDto profileDto)
    {
        ProfileModel profileModel=new ProfileModel();

        profileModel.setProfileId(profileDto.getProfileId());
        profileModel.setProfileImg(profileDto.getProfileImg());
        profileModel.setProfileName(profileDto.getProfileName());
        profileModel.setProfileQualification(profileDto.getProfileQualification());
        profileModel.setStatus(profileDto.getStatus());

        boolean flag=loginDao.updateProfileDetails(profileModel);
        return flag;
    }

    @Override
    public boolean deleteProfileCtrl(Integer profileId)
    {
        boolean flag=loginDao.deleteProfile(profileId);
        return flag;
    }

    @Override
    public List getRegistrationRecordController()
    {
        List registrationList=loginDao.getRegistrationDetails();
        return registrationList;
    }

    @Override
    public LoginDto editRegistrationCtrl(Integer loginId)
    {
        LoginDto loginDto=loginDao.editRegistration(loginId);
        return loginDto;
    }

    @Override
    public boolean updateRegistrationCtrl(LoginDto loginDto)
    {
        LoginModel loginModel=new LoginModel();

        loginModel.setLoginId(loginDto.getLoginId());
        loginModel.setName(loginDto.getName());
        loginModel.setUsername(loginDto.getUsername());
        loginModel.setPassword(loginDto.getPassword());
        loginModel.setRepeatPassword(loginDto.getRepeatPassword());

        boolean flag=loginDao.updateRegistrationRecord(loginModel);
        return flag;
    }

    @Override
    public boolean deleteRegistrationCtrl(Integer loginId)
    {
        boolean flag=loginDao.deleteRegistrationRecord(loginId);
        return flag;
    }

    @Override
    public boolean insertAddressCtrl(AddressDto addressDto)
    {
        AddressModel addressModel=new AddressModel();

        addressModel.setAddress(addressDto.getAddress());
        addressModel.setStatus(addressDto.getStatus());

        boolean flag=loginDao.insertAddress(addressModel);
        return flag;
    }

    @Override
    public List getAddressCtrl()
    {
        List list=loginDao.getAddressDetails();
        return list;
    }

    @Override
    public AddressDto editAddressCtrl(Integer addressId)
    {
        AddressDto addressDto=loginDao.editAddress(addressId);
        return addressDto;
    }

    @Override
    public boolean updateAddressCtrl(AddressDto addressDto)
    {
        AddressModel addressModel=new AddressModel();

        addressModel.setAddressId(addressDto.getAddressId());
        addressModel.setAddress(addressDto.getAddress());
        addressModel.setStatus(addressDto.getStatus());

        boolean flag=loginDao.updateAddressRecord(addressModel);
        return flag;
    }


    @Override
    public boolean deleteAddressCtrl(Integer addressId)
    {
        boolean flag=loginDao.deleteAddressRecord(addressId);
        return flag;
    }



    @Override
    public boolean insertImageWiseStatuseService(ActiveImageDto activeImageDto) {

        ActiveImageMaster activeImageMaster=new ActiveImageMaster();
        activeImageMaster.setHomePageImg(activeImageDto.getHomePageImg());

        activeImageMaster.setStatus(activeImageDto.getStatus());

        boolean flag=loginDao.insertStatusDao(activeImageMaster);
        return flag;
    }

    @Override
    public List getImageController() {

        List list=loginDao.getImageService();
        return list;
    }

    @Override
    public ActiveImageDto editImageCtrl(Integer imageId) {

        ActiveImageDto activeImageDto=loginDao.editImageStatus(imageId);
        return activeImageDto;
    }

    @Override
    public boolean updateImageCtrl(ActiveImageDto activeImageDto) {

        ActiveImageMaster activeImageMaster=new ActiveImageMaster();
        activeImageMaster.setImageId(activeImageDto.getImageId());
        activeImageMaster.setHomePageImg(activeImageDto.getHomePageImg());

        activeImageMaster.setStatus(activeImageDto.getStatus());

        boolean flag=loginDao.updateImageStatusDao(activeImageMaster);
        return flag;

    }

    @Override
    public List getActiveImageController() {
        List list=loginDao.getActiveStatusImageService();
        return list;
    }

    @Override
    public boolean insertGalleryController(GalleryDto galleryDto) {

        GalleryModel galleryModel=new GalleryModel();

        galleryModel.setGalleryName(galleryDto.getGalleryName());
        galleryModel.setStatus(galleryDto.getStatus());
        boolean flag=loginDao.insertGalleryService(galleryModel);
        return flag;
    }

    @Override
    public List getGalleryImageController() {

        List list=loginDao.getGalleryService();
        return list;
    }

    @Override
    public GalleryDto editGalleryCtrl(Integer galleryId) {
        GalleryDto galleryDto=loginDao.editGalleryStatus(galleryId);
        return galleryDto;
    }

    @Override
    public boolean updateGalleryCtrl(GalleryDto galleryDto) {

        GalleryModel galleryModel=new GalleryModel();
        galleryModel.setGalleryId(galleryDto.getGalleryId());
        galleryModel.setGalleryName(galleryDto.getGalleryName());
        galleryModel.setStatus(galleryDto.getStatus());

        boolean flag=loginDao.updateGalleryService(galleryModel);
        return flag;
    }

    @Override
    public List getActiveGalleryImageController() {
        List list=loginDao.getActiveGalleryService();
        return list;
    }

    @Override
    public boolean insertContentController(ContentDto contentDto) {
        ContentModel contentModel=new ContentModel();

        contentModel.setContentName(contentDto.getContentName());
        contentModel.setStatus(contentDto.getStatus());
        boolean flag=loginDao.insertContentService(contentModel);
        return flag;
    }

    @Override
    public List getContentController() {
        List list=loginDao.getContentService();
        return list;
    }

    @Override
    public ContentDto editContentCtrl(Integer contentId) {

        ContentDto contentDto=loginDao.editContentStatus(contentId);
        return contentDto;
    }

    @Override
    public boolean updateContentCtrl(ContentDto contentDto) {
        ContentModel contentModel=new ContentModel();
        contentModel.setContentId(contentDto.getContentId());
        contentModel.setContentName(contentDto.getContentName());
        contentModel.setStatus(contentDto.getStatus());

        boolean flag=loginDao.updateContentService(contentModel);
        return flag;
    }

    @Override
    public List getActiveContentController() {
        List list=loginDao.getActiveContentService();
        return list;
    }




}
