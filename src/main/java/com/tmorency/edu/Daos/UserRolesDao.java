package com.tmorency.edu.Daos;

import com.tmorency.edu.entity.UserChores;
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
        session.close();
        return rms;
    }

    public UserRoles getUser(String user_name) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserRoles rm = (UserRoles) session.get(UserRoles.class, user_name);
        session.close();
        return rm;
    }

    public UserRoles insertUser(UserRoles rm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rm);
        session.getTransaction().commit();
        session.close();
        return rm;
    }

    public List<UserRoles> searchUserRoles(String fieldName, String searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserRoles.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        List<UserRoles> urs = new ArrayList<UserRoles>();
        urs = criteria.list();
        session.close();
        return urs;
    }

    public UserRoles deleteUser(String user_name) {
        UserRoles rm = getUser(user_name);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rm);
        session.getTransaction().commit();
        session.close();
        return rm;
    }

}
