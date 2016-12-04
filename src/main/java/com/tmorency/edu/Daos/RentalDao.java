package com.tmorency.edu.Daos;

import com.tmorency.edu.entity.Rental;
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

public class RentalDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<Rental> getAllRental() {
        List<Rental> rms = new ArrayList<Rental>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rms = session.createCriteria(Rental.class).list();
        session.close();
        return rms;
    }

    public Rental getRental(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Rental rm = (Rental) session.get(Rental.class, id);
        session.close();
        return rm;
    }

    public Rental insertNewRental(Rental rm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rm);
        session.getTransaction().commit();
        session.close();
        return rm;
    }

    public List<Rental> searchRentals(String fieldName, String searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Rental.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        List<Rental> rs = new ArrayList<Rental>();
        rs = criteria.list();
        session.close();
        return rs;
    }

    public Rental deleteRental(int id) {
        Rental rm = getRental(id);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rm);
        session.getTransaction().commit();
        session.close();
        return rm;
    }
}

