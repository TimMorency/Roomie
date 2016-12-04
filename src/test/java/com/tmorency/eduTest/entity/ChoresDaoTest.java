package com.tmorency.eduTest.entity;

import com.tmorency.edu.Daos.ChoresDao;
import com.tmorency.edu.entity.Chores;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tim on 10/25/2016.
 */
public class ChoresDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    private ChoresDao rmd;

    @Before
    public void setup() {
        rmd = new ChoresDao();
    }
    @Test
    public void getAllChores() throws Exception {
        List<Chores> rms = rmd.getAllChores();
        logger.info(rms);
        boolean checker = false;
        if(rms.size() > 0) {
            checker = true;
        }
        assertTrue(checker);
    }

    @Test
    public void getChores() throws Exception {
        int id = 1;

        Chores rm = rmd.getChores(id);
        logger.info(rm);
        assertTrue(rm.getChore_name().length() > 0);
    }

    @Test
    public void insertNewChoresAndDelete() throws Exception {
        Chores ch = new Chores(2, "test2", "test2", 1);
        Chores ch2 = rmd.insertNewChores(ch);
        assertEquals(ch2.getChore_name(), ch.getChore_name());
        Chores ch3 = rmd.deleteChores(ch2.getId());
        assertEquals(ch3.getId(), ch2.getId());
    }

    @Test
    public void searchChores() throws Exception {
        List<Chores> rms = new ArrayList<Chores>();
        rms = rmd.searchChores("rental_id", 1);
        logger.info(rms);
        assertTrue(rms.size() > 0);
    }


}