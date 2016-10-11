package com.tmorency.edu.controller;

import com.tmorency.edu.entity.UserBills;
import com.tmorency.edu.persistence.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 10/11/2016.
 */

public class UserBillsDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<UserBills> getAllUserBills() {
        List<UserBills> rms = new ArrayList<UserBills>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rms = session.createCriteria(UserBills.class).list();
        return rms;
    }

    public UserBills getUserBills(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserBills rm = (UserBills) session.get(UserBills.class, id);
        return rm;
    }

    public UserBills insertNewUserBills(UserBills rm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rm);
        session.getTransaction().commit();
        return rm;
    }

    public List<UserBills> searchUserBillss(String fieldName, String searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserBills.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        return criteria.list();
    }

    public UserBills deleteUserBills(int id) {
        UserBills rm = getUserBills(id);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rm);
        session.getTransaction().commit();
        return rm;
    }
}

