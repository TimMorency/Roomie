package com.tmorency.edu.controller;

import com.tmorency.edu.entity.UserChores;
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

public class UserChoresDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<UserChores> getAllUserChores() {
        List<UserChores> rms = new ArrayList<UserChores>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rms = session.createCriteria(UserChores.class).list();
        return rms;
    }

    public UserChores getUserChores(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserChores rm = (UserChores) session.get(UserChores.class, id);
        return rm;
    }

    public UserChores insertNewUserChores(UserChores rm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rm);
        session.getTransaction().commit();
        return rm;
    }

    public List<UserChores> searchUserChoress(String fieldName, String searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserChores.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        return criteria.list();
    }

    public UserChores deleteUserChores(int id) {
        UserChores rm = getUserChores(id);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rm);
        session.getTransaction().commit();
        return rm;
    }
}

