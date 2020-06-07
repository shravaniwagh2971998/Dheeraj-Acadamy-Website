package com.techcelestial.dheerajacademy.dao.impl;

import com.techcelestial.dheerajacademy.dao.WebEnquiryDao;
import com.techcelestial.dheerajacademy.model.WebEnquiry;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WebEnquiryDaoImpl implements WebEnquiryDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public boolean addEnquiry(WebEnquiry webEnquiry) {
        Session session=null;
        try{
            System.out.println("Inside Dao");
            session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.save(webEnquiry);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

    @Override
    public List getWebEnquiry() {
        Session session=null;
        List list=null;
        try{

            session=sessionFactory.openSession();
            Query query=session.createQuery("Select we.date as date, we.wenEnquiryId as wenEnquiryId, we.email as email, we.messasge as messasge,we.contact as contact from WebEnquiry as we order by we.wenEnquiryId desc");

            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            list=query.list();

        }
        catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public boolean deleteContact(Integer wenEnquiryId)
    {
        Session session=null;
        try
        {
            session=sessionFactory.openSession();
            Transaction tr=session.beginTransaction();
            Query query=session.createQuery("delete from WebEnquiry as wm where wm.wenEnquiryId=:wenEnquiryId");
            query.setParameter("wenEnquiryId",wenEnquiryId);
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
}
