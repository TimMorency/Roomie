package com.tmorency.eduTest.entity;

import com.tmorency.edu.entity.UserRoles;
import org.apache.log4j.Logger;
import com.tmorency.edu.Daos.UserRolesDao;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tim on 10/20/2016.
 */
public class UserRolesDaoTest {
    private final Logger logger = Logger.getLogger(this.getClass());
    private UserRolesDao bl;

    @Before
    public void setup() {
        bl = new UserRolesDao();
    }

    @Test
    public void getAllUserRoles() throws Exception {
        List<UserRoles> rms = bl.getAllUserRoles();
        logger.info(rms);
        boolean checker = false;
        if(rms.size() > 0) {
            checker = true;
        }
        assertTrue(checker);

    }

    @Test
    public void getUserRoles() throws Exception {
        //int id, String bill_name, int bill_amt, Date due_date, int rentalId
        String tester = "tester";

        UserRoles rm = bl.getUser(tester);
        logger.info(rm);
        assertTrue(rm.getUserName().length() > 0);

    }


    @Test
    public void searchUserRoles() throws Exception {
        List<UserRoles> rms = new ArrayList<UserRoles>();
        rms = bl.searchUserRoles("userName", "tester");
        logger.info(rms);
        assertTrue(rms.size() > 0);
    }


}