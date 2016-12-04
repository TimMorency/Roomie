package com.tmorency.eduTest.entity;

import com.tmorency.edu.entity.Users;
import org.apache.log4j.Logger;
import com.tmorency.edu.Daos.UsersDao;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tim on 10/20/2016.
 */
public class UsersDaoTest {
    private final Logger logger = Logger.getLogger(this.getClass());
    private UsersDao bl;

    @Before
    public void setup() {
        bl = new UsersDao();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<Users> rms = bl.getAllUsers();
        logger.info(rms);
        boolean checker = false;
        if(rms.size() > 0) {
            checker = true;
        }
        assertTrue(checker);

    }

    @Test
    public void getUsers() throws Exception {
        //int id, String bill_name, int bill_amt, Date due_date, int rentalId
        String tester = "tester";

        Users rm = bl.getUser(tester);
        logger.info(rm);
        assertTrue(rm.getUser_name().length() > 0);

    }


    @Test
    public void searchUsers() throws Exception {
        List<Users> rms = new ArrayList<Users>();
        rms = bl.searchUsers("user_name", "tester");
        logger.info(rms);
        assertTrue(rms.size() > 0);
    }


}