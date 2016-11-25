package com.tmorency.edu.controller;

import com.tmorency.edu.entity.UserRoles;
import com.tmorency.edu.persistence.SessionFactoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 10/11/2016.
 */
public class UserRolesDao {

    public List<UserRoles> getAllUserRoles() {
        List<UserRoles> rms = new ArrayList<UserRoles>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rms = session.createCriteria(UserRoles.class).list();
        return rms;
    }

    public UserRoles getUser(String user_name) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserRoles rm = (UserRoles) session.get(UserRoles.class, user_name);
        return rm;
    }

    public UserRoles insertUser(UserRoles rm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rm);
        session.getTransaction().commit();
        return rm;
    }

    public List<UserRoles> searchUserRoles(String fieldName, String searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserRoles.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        return criteria.list();
    }

    public UserRoles deleteUser(String user_name) {
        UserRoles rm = getUser(user_name);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rm);
        session.getTransaction().commit();
        return rm;
    }

}
