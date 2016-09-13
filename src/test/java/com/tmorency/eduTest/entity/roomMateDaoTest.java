package com.tmorency.eduTest.entity;

import com.tmorency.edu.controller.roomMateDao;
import com.tmorency.edu.entity.roomMate;
import org.apache.log4j.Logger;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Created by Tim on 9/13/2016.
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
}
