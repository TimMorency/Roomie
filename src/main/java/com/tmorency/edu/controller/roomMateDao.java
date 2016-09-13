package com.tmorency.edu.controller;

import com.tmorency.edu.entity.roomMate;
import com.tmorency.edu.persistence.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.Session;

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
}
