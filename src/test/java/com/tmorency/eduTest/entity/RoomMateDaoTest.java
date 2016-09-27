package com.tmorency.eduTest.entity;

import com.tmorency.edu.controller.RoomMateDao;
import com.tmorency.edu.entity.RoomMate;
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
public class RoomMateDaoTest {
    private final Logger logger = Logger.getLogger(this.getClass());
    private RoomMateDao rmd;

    @Before
    public void setup() {
        rmd = new RoomMateDao();
    }

    @Test
    public void testGetAllRoomies() {
        List<RoomMate> rms = rmd.getAllRoomies();
        logger.info(rms);
        boolean checker = false;
        if(rms.size() > 0) {
            checker = true;
        }
        assertTrue(checker);

    }

    @Test
    public void testInsert() {
        RoomMate rm1 = new RoomMate();
        rm1.setFirstName("TestFirst");
        rm1.setLastName("testLast");
        rm1.setEmail("test@test.com");
        rm1.setPhoneNumber("608-123-4567");
        rm1.setRentalId(1);
        RoomMate rm = rmd.insertNewRoomMate(rm1);
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

        RoomMate rm = rmd.getRoomMate(id);
        logger.info(rm);
        assertTrue(rm.getFirstName().length() > 0);
    }

    @Test
    public void testSearch() {
        List<RoomMate> rms = new ArrayList<RoomMate>();
        rms = rmd.searchRoomMates("firstName", "Tim");
        logger.info(rms);
        assertTrue(rms.size() > 0);
    }

    @Test
    public void testDelete() {
        RoomMate rm1 = new RoomMate();
        rm1.setFirstName("TestFirst");
        rm1.setLastName("testLast");
        rm1.setEmail("test@test.com");
        rm1.setPhoneNumber("608-123-4567");
        rm1.setRentalId(1);
        RoomMate rm = rmd.insertNewRoomMate(rm1);
        logger.info(rm.getId());
        RoomMate rm2 = rmd.deleteRoomMate(rm.getId());
        assertEquals(rm2.getId(), rm.getId());
    }
}


