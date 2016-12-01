package com.tmorency.eduTest.entity;

import com.tmorency.edu.controller.RoomMateDao;
import com.tmorency.edu.controller.UserBillsDao;
import com.tmorency.edu.entity.Chores;
import com.tmorency.edu.entity.UserBills;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tim on 10/27/2016.
 */
public class UserBillsDaoTest {


    private final Logger logger = Logger.getLogger(this.getClass());
    private UserBillsDao rmd;

    @Before
    public void setup() {
        rmd = new UserBillsDao();
    }

    @Test
    public void getAllUserBills() throws Exception {
        List<UserBills> rms = rmd.getAllUserBills();
        logger.info(rms);
        boolean checker = false;
        if(rms.size() > 0) {
            checker = true;
        }
        assertTrue(checker);
    }

    @Test
    public void getUserBills() throws Exception {
        int id = 1;

        UserBills rm = rmd.getUserBills(id);
        logger.info(rm);
        assertTrue(rm.getId() > 0);
    }

    @Test
    public void insertNewUserBills() throws Exception {
        UserBills ub = new UserBills(1, 1, 10, new Date(), 1, true);
        UserBills ub2 = rmd.insertNewUserBills(ub);

        assert(ub2.getId() > 0);

        UserBills ub3 = rmd.deleteUserBills(ub2.getId());
        assertEquals(ub2.getId(), ub3.getId());
    }

    @Test
    public void searchUserBillss() throws Exception {
        List<UserBills> rms = new ArrayList<UserBills>();
        rms = rmd.searchUserBillss("split_amt", 10);
        logger.info(rms);
        assertTrue(rms.size() > 0);
    }

}