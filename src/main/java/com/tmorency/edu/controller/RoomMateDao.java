package com.tmorency.edu.controller;

import com.tmorency.edu.entity.RoomMate;
import com.tmorency.edu.persistence.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 9/13/2016.
 * comments ++
 * need to add lookup on the rooMate object in database.
 * also need to fix name capitalization in java classes.
 * add new object for house and add chores/ bills as well.
 */
public class RoomMateDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<RoomMate> getAllRoomies() {
        List<RoomMate> rms = new ArrayList<RoomMate>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rms = session.createCriteria(RoomMate.class).list();
        return rms;
    }

    public RoomMate getRoomMate(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        RoomMate rm = (RoomMate) session.get(RoomMate.class, id);
        return rm;
    }

    public RoomMate insertNewRoomMate(RoomMate rm) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rm);
        session.getTransaction().commit();
        return rm;
    }

    public List<RoomMate> searchRoomMates(String fieldName, String searchVal) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(RoomMate.class);
        criteria.add(Restrictions.eq(fieldName, searchVal));
        return criteria.list();
    }

    public RoomMate deleteRoomMate(int id) {
        RoomMate rm = getRoomMate(id);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(rm);
        session.getTransaction().commit();
        return rm;
    }
}
