package com.tmorency.eduTest.entity;

import com.tmorency.edu.entity.Bills;
import org.apache.log4j.Logger;
import com.tmorency.edu.controller.BillsDao;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Tim on 10/20/2016.
 */
public class BillsDaoTest {
    private final Logger logger = Logger.getLogger(this.getClass());
    private BillsDao bl;

    @Before
    public void setup() {
        bl = new BillsDao();
    }

    @Test
    public void getAllBills() throws Exception {
        List<Bills> rms = bl.getAllBills();
        logger.info(rms);
        boolean checker = false;
        if(rms.size() > 0) {
            checker = true;
        }
        assertTrue(checker);

    }

    @Test
    public void getBills() throws Exception {
        //int id, String bill_name, int bill_amt, Date due_date, int rentalId
        int id = 1;

        Bills rm = bl.getBills(id);
        logger.info(rm);
        assertTrue(rm.getBill_name().length() > 0);

    }

    @Test
    public void insertNewBills() throws Exception {
        Bills bl1 = new Bills();
        bl1.setRentalId(1);
        bl1.setBill_amt(10);
        bl1.setBill_name("Name");
        Bills bl2 = bl.insertNewBills(bl1);

        assertTrue(bl2.getId() > 0);
    }

    @Test
    public void searchBills() throws Exception {
        List<Bills> rms = new ArrayList<Bills>();
        rms = bl.searchBills("bill_name", "Name");
        logger.info(rms);
        assertTrue(rms.size() > 0);
    }

    @Test
    public void deleteBills() throws Exception {

        Bills bl1 = new Bills();
        bl1.setRentalId(1);
        bl1.setBill_amt(10);
        bl1.setBill_name("Name");
        Bills bl2 = bl.insertNewBills(bl1);

        Bills bl3 = bl.deleteBills(bl2.getId());

        assertEquals(bl3.getId(), bl2.getId());
    }

}