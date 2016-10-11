package com.tmorency.edu.controller;

import com.tmorency.edu.entity.Chores;
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

public class ChoresDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<Chores> getAllChores() {
        List<Chores> rms = new ArrayList<Chores>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rms = session.createCriteria(Chores.class).list();
        return rms;
    }

    public Chores getChores(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Chores rm = (Chores) session.get(Chores.class, id);
        return rm;
    }

    public Chores insertNewChores(Chores rm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rm);
        session.getTransaction().commit();
        return rm;
    }

    public List<Chores> searchChores(String fieldName, String searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Chores.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        return criteria.list();
    }

    public Chores deleteChores(int id) {
        Chores rm = getChores(id);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rm);
        session.getTransaction().commit();
        return rm;
    }
}

