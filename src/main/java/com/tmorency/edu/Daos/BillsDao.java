package com.tmorency.edu.Daos;

import com.tmorency.edu.entity.Bills;
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

public class BillsDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<Bills> getAllBills() {
        List<Bills> rms = new ArrayList<Bills>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rms = session.createCriteria(Bills.class).list();
        session.close();
        return rms;
    }

    public Bills getBills(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Bills rm = (Bills) session.get(Bills.class, id);
        session.close();
        return rm;
    }

    public Bills insertNewBills(Bills rm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rm);
        session.getTransaction().commit();
        session.close();
        return rm;
    }

    public List<Bills> searchBills(String fieldName, int searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Bills.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        List<Bills> bs = new ArrayList<Bills>();
        bs = criteria.list();
        session.close();
        return bs;
    }

    public Bills deleteBills(int id) {
        Bills rm = getBills(id);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rm);
        session.getTransaction().commit();
        session.close();
        return rm;
    }
}

