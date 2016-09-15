package com.tmorency.edu.controller;

import com.tmorency.edu.entity.roomMate;
import com.tmorency.edu.persistence.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 9/13/2016.
 */
public class roomMateDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<roomMate> getAllRoomies() {
        List<roomMate> rms = new ArrayList<roomMate>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rms = session.createCriteria(roomMate.class).list();
        return rms;
    }

    public roomMate getRoomMate(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        roomMate rm = (roomMate) session.get(roomMate.class, id);
        return rm;
    }

    public roomMate insertNewRoomMate(String firstName, String lastName, String email, String phoneNumber) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        roomMate rmNew = new roomMate();
        rmNew.setEmail(email);
        rmNew.setFirstName(firstName);
        rmNew.setLastName(lastName);
        rmNew.setPhoneNumber(phoneNumber);
        session.save(rmNew);
        session.getTransaction().commit();
        return rmNew;
    }

    public List<roomMate> searchRoomMates(String fieldName, String searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(roomMate.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        return criteria.list();
    }
}
