package com.tmorency.edu.Daos;

import com.tmorency.edu.entity.Users;
import com.tmorency.edu.persistence.SessionFactoryProvider;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 10/11/2016.
 */
public class UsersDao {

    //todo add user check when signing up
    public List<Users> getAllUsers() {
        List<Users> rms = new ArrayList<Users>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rms = session.createCriteria(Users.class).list();
        session.close();
        return rms;
    }

    public Users getUser(String user_name) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Users rm = (Users) session.get(Users.class, user_name);
        session.close();
        return rm;
    }

    public Users insertUser(Users rm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rm);
        session.getTransaction().commit();
        session.close();
        return rm;
    }

    public List<Users> searchUsers(String fieldName, String searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        List<Users> us = new ArrayList<Users>();
        us = criteria.list();
        session.close();
        return us;
    }

    public Users deleteUser(String user_name) {
        Users rm = getUser(user_name);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rm);
        session.getTransaction().commit();
        session.close();
        return rm;
    }

}
