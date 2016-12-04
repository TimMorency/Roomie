package com.tmorency.eduTest.entity;

import com.tmorency.edu.Daos.UserChoresDao;
import com.tmorency.edu.entity.UserChores;
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
public class UserChoresDaoTest {


    private final Logger logger = Logger.getLogger(this.getClass());
    private UserChoresDao rmd;

    @Before
    public void setup() {
        rmd = new UserChoresDao();
    }

    @Test
    public void getAllUserChores() throws Exception {
        List<UserChores> rms = rmd.getAllUserChores();
        logger.info(rms);
        boolean checker = false;
        if(rms.size() > 0) {
            checker = true;
        }
        assertTrue(checker);
    }

    @Test
    public void getUserChores() throws Exception {
        int id = 1;

        UserChores rm = rmd.getUserChores(id);
        logger.info(rm);
        assertTrue(rm.getId() > 0);
    }

    @Test
    public void insertNewUserChores() throws Exception {
        UserChores ub = new UserChores( 1, 1, new Date(),true);
        UserChores ub2 = rmd.insertNewUserChores(ub);

        assert(ub2.getId() > 0);

        UserChores ub3 = rmd.deleteUserChores(ub2.getId());
        assertEquals(ub2.getId(), ub3.getId());
    }

    @Test
    public void searchUserChoress() throws Exception {
        List<UserChores> rms = new ArrayList<UserChores>();
        rms = rmd.searchUserChoress("chore_id", 1);
        logger.info(rms);
        assertTrue(rms.size() > 0);
    }

}