package com.tmorency.eduTest.entity;

import com.tmorency.edu.controller.roomMateDao;
import com.tmorency.edu.entity.roomMate;
import org.apache.log4j.Logger;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Tim on 9/13/2016.
 * comments ++
 */
public class roomMateDaoTest {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void testGetAllRoomies() {
        roomMateDao rmd = new roomMateDao();
        List<roomMate> rms = rmd.getAllRoomies();
        logger.info(rms);
        boolean checker = false;
        if(rms.size() > 0) {
            checker = true;
        }
        assertTrue(checker);

    }

    @Test
    public void testInsert() {
        roomMateDao rmd = new roomMateDao();
        roomMate rm = rmd.insertNewRoomMate("TestFirst", "testLast", "test@test.com","608-123-4567");
        logger.info(rm);
        assertEquals("TestFirst", rm.getFirstName());

        int checker = 0;
        if(rm.getId() > 0) {
            checker = rm.getId();
        }
        assertTrue(checker > 0);
    }

    @Test
    public void getSingleRoomMate() {
        int id = 1;

        roomMateDao rmd = new roomMateDao();
        roomMate rm = rmd.getRoomMate(id);
        logger.info(rm);
        assertTrue(rm.getFirstName().length() > 0);
    }

    @Test
    public void testSeach() {
        roomMateDao rmd = new roomMateDao();
        List<roomMate> rms = new ArrayList<roomMate>();
        rms = rmd.searchRoomMates("firstName", "Tim");
        logger.info(rms);
        assertTrue(rms.size() > 0);
    }

    @Test
    public void testDelete() {
        roomMateDao rmd = new roomMateDao();
        roomMate rm = rmd.insertNewRoomMate("TestDelete", "testLast", "test@test.com", "608-123-7890");
        logger.info(rm.getId());
        roomMate rm2 = rmd.deleteRoomMate(rm.getId());
        assertEquals(rm2.getId(), rm.getId());
    }
}


