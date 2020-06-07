package com.techcelestial.dheerajacademy.dao.impl;

import com.techcelestial.dheerajacademy.dao.LoginDao;
import com.techcelestial.dheerajacademy.dto.*;
import com.techcelestial.dheerajacademy.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean insertRegisterRecord(LoginModel loginModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(loginModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public List<LoginModel> getLoginRecord()
    {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from LoginModel");
//                query.setParameter("status",status);
           // query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            list=query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
    }
    @Override
    public String getUsername(String username)
    {
        Session session=null;
        //List list=null;
        String name=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select lm.username as username from LoginModel as lm where lm.status='active' and lm.username=:username");
               query.setParameter("username",username);
            // query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
             name=(String)query.uniqueResult();
           // username=(String)query.uniqueResult();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return name;
    }

    @Override
    public String getPass(String password) {

        Session session=null;
        //List list=null;
        String password1=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("select lm.password as password from LoginModel as lm where lm.status='active' and lm.password=:password");
            query.setParameter("password",password);
            // query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            password1=(String)query.uniqueResult();
            // username=(String)query.uniqueResult();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return password1;

    }

    @Override
    public boolean insertProfileDetails(ProfileModel profileModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(profileModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public List getProfileDetails()
    {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from ProfileModel");
            list=query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public boolean insertNewPassword(ForgotModel forgotModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(forgotModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public Integer getUpdateInfo(LoginModel loginModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(loginModel);
            tr.commit();
            return 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;

        }
        finally {
            session.close();
        }

    }

    @Override
    public ProfileDto editProfile(Integer profileId)
    {
        Session session=null;
        ProfileDto profileDto=new ProfileDto();

        try
        {
            session=sessionFactory.openSession();
            ProfileModel profileModel=session.load(ProfileModel.class,profileId);

            profileDto.setProfileId(profileModel.getProfileId());
            profileDto.setProfileImg(profileModel.getProfileImg());
            profileDto.setProfileName(profileModel.getProfileName());
            profileDto.setProfileQualification(profileModel.getProfileQualification());
            profileDto.setStatus(profileModel.getStatus());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return profileDto;

    }

    @Override
    public boolean updateProfileDetails(ProfileModel profileModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(profileModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }
    @Override
    public boolean deleteProfile(Integer profileId)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            Query query=session.createQuery("delete from ProfileModel as pm where pm.profileId=:profileId");
            query.setParameter("profileId",profileId);
            query.executeUpdate();
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public List getRegistrationDetails()
    {
        Session session=null;
        List registrationList=null;
        try
        {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from LoginModel");
            registrationList=query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return registrationList;
    }

    @Override
    public LoginDto editRegistration(Integer loginId)
    {
        Session session=null;
        LoginDto loginDto=new LoginDto();

        try
        {
            session=sessionFactory.openSession();
            LoginModel loginModel=session.load(LoginModel.class,loginId);

            loginDto.setLoginId(loginModel.getLoginId());
            loginDto.setName(loginModel.getName());
            loginDto.setUsername(loginModel.getUsername());
            loginDto.setPassword(loginModel.getPassword());
            loginDto.setRepeatPassword(loginModel.getRepeatPassword());
            loginDto.setStatus(loginModel.getStatus());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return loginDto;

    }

    @Override
    public boolean updateRegistrationRecord(LoginModel loginModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(loginModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean deleteRegistrationRecord(Integer loginId)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            Query query=session.createQuery("delete from LoginModel as lm where lm.loginId=:loginId");
            query.setParameter("loginId",loginId);
            query.executeUpdate();
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public boolean insertAddress(AddressModel addressModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(addressModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public List getAddressDetails()
    {
        Session session=null;
        List list=null;
        try
        {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from AddressModel");
            list=query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public AddressDto editAddress(Integer addressId)
    {
        Session session=null;
        AddressDto addressDto=new AddressDto();

        try
        {
            session=sessionFactory.openSession();
            AddressModel addressModel=session.load(AddressModel.class,addressId);

            addressDto.setAddressId(addressModel.getAddressId());
            addressDto.setAddress(addressModel.getAddress());
            addressDto.setStatus(addressModel.getStatus());


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return addressDto;
    }

    @Override
    public boolean updateAddressRecord(AddressModel addressModel)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(addressModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }
    @Override
    public boolean deleteAddressRecord(Integer addressId)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            Query query=session.createQuery("delete from AddressModel as am where am.addressId=:addressId");
            query.setParameter("addressId",addressId);
            query.executeUpdate();
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }




    @Override
    public boolean insertStatusDao(ActiveImageMaster activeImageMaster) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(activeImageMaster);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }

    }

    @Override
    public List getImageService() {

        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from ActiveImageMaster");
            list=query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public ActiveImageDto editImageStatus(Integer imageId) {

        Session session=null;
        ActiveImageDto activeImageDto=new ActiveImageDto();

        try
        {
            session=sessionFactory.openSession();
            ActiveImageMaster activeImageMaster=session.load(ActiveImageMaster.class,imageId);


            activeImageDto.setImageId(activeImageMaster.getImageId());
            activeImageDto.setHomePageImg(activeImageMaster.getHomePageImg());
            activeImageDto.setStatus(activeImageMaster.getStatus());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return activeImageDto;
    }

    @Override
    public boolean updateImageStatusDao(ActiveImageMaster activeImageMaster) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(activeImageMaster);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public List getActiveStatusImageService() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from ActiveImageMaster as activeImageMaster where activeImageMaster.status='active'");
            list=query.list();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public boolean insertGalleryService(GalleryModel galleryModel) {

        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(galleryModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public List getGalleryService() {
        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from GalleryModel as galleryModel");
            list=query.list();

        }
        catch (Exception e)
        {
            e.printStackTrace();


        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public GalleryDto editGalleryStatus(Integer galleryId) {

        Session session=null;
        GalleryDto galleryDto=new GalleryDto();

        try
        {
            session=sessionFactory.openSession();
            GalleryModel galleryModel=session.load(GalleryModel.class,galleryId);


            galleryDto.setGalleryId(galleryModel.getGalleryId());
            galleryDto.setGalleryName(galleryModel.getGalleryName());
            galleryDto.setStatus(galleryModel.getStatus());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return galleryDto;
    }

    @Override
    public boolean updateGalleryService(GalleryModel galleryModel) {

        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(galleryModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public List getActiveGalleryService() {

        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from GalleryModel as galleryModel where galleryModel.status='active'");
            list=query.list();

        }
        catch (Exception e)
        {
            e.printStackTrace();


        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public boolean insertContentService(ContentModel contentModel) {

        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.save(contentModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public List getContentService() {

        Session session=null;
        List list=null;
        try {
            session=sessionFactory.openSession();
            Query query=session.createQuery("from ContentModel as contentModel");
            list=query.list();

        }
        catch (Exception e)
        {
            e.printStackTrace();


        }
        finally {
            session.close();
        }
        return list;
    }

    @Override
    public ContentDto editContentStatus(Integer contentId) {

        Session session=null;
        ContentDto contentDto=new ContentDto();

        try
        {
            session=sessionFactory.openSession();
            ContentModel contentModel=session.load(ContentModel.class,contentId);


            contentDto.setContentId(contentModel.getContentId());
            contentDto.setContentName(contentModel.getContentName());
            contentDto.setStatus(contentModel.getStatus());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return contentDto;
    }

    @Override
    public boolean updateContentService(ContentModel contentModel) {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            session.update(contentModel);
            tr.commit();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;

        }
        finally {
            session.close();
        }
    }

    @Override
    public List getActiveContentService() {

        Session session = null;
        List list = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from ContentModel as contentModel where contentModel.status='active'");
            list = query.list();

        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            session.close();
        }
        return list;
    }
    }
