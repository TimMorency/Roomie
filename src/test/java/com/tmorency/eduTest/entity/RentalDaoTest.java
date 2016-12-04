package com.tmorency.eduTest.entity;

import com.tmorency.edu.Daos.RentalDao;
import com.tmorency.edu.entity.Rental;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tim on 10/25/2016.
 */
public class RentalDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    private RentalDao rmd;

    @Before
    public void setup() {
        rmd = new RentalDao();
    }

    @Test
    public void getAllRental() throws Exception {
        List<Rental> rms = rmd.getAllRental();
        logger.info(rms);
        boolean checker = false;
        if(rms.size() > 0) {
            checker = true;
        }
        assertTrue(checker);
    }

    @Test
    public void getRental() throws Exception {
        int id = 1;

        Rental rm = rmd.getRental(id);
        logger.info(rm);
        assertTrue(rm.getAddress().length() > 0);
    }

    @Test
    public void insertNewRentalAndDelete() throws Exception {
        Rental r = new Rental("14 wilton ct", "Madison", "Wisconsin",
                "53704", new Date(), new Date(), 100);
        Rental r2 = rmd.insertNewRental(r);
        assertEquals(r2.getAddress(), r.getAddress());
        Rental r3 = rmd.deleteRental(r2.getId());
        assertEquals(r2.getAddress(), r3.getAddress());
    }

    @Test
    public void searchRentals() throws Exception {
        List<Rental> rms = new ArrayList<Rental>();
        rms = rmd.searchRentals("address", "348 pasque st");
        logger.info(rms);
        assertTrue(rms.size() > 0);
    }

}