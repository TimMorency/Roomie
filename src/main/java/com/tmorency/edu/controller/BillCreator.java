package com.tmorency.edu.controller;

import com.tmorency.edu.Daos.*;
import com.tmorency.edu.entity.Bills;
import com.tmorency.edu.entity.Rental;
import com.tmorency.edu.entity.RoomMate;
import com.tmorency.edu.entity.UserBills;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 12/3/2016.
 */
public class BillCreator {

    private final Logger log = Logger.getLogger(this.getClass());

    public BillsDao bd;
    public UsersDao ud;
    public RentalDao rd;
    public RoomMateDao rmd;
    public String uName;

    public BillCreator(String userName) {
        bd = new BillsDao();
        ud = new UsersDao();
        rd = new RentalDao();
        rmd = new RoomMateDao();
        uName = userName;
    }

    public BillCreator() {
    }

    public List<RoomMate> getAllOtherRoomMates() {
        List<RoomMate> rms = rmd.searchRoomMates("user_name_fk", uName);
        RoomMate roomie = rms.get(0);
        List<RoomMate> returners = rmd.searchRoomMatesInt("rentalId", roomie.getRentalId());
        return returners;
    }


    public Rental getRental() {
        List<RoomMate> rms = rmd.searchRoomMates("user_name_fk", uName);
        RoomMate roomie = rms.get(0);
        Rental r = rd.getRental(roomie.getRentalId());
        return r;
    }
    public Bills insertBill(Bills insertedBill) {
        Bills returnBill = bd.insertNewBills(insertedBill);
        return returnBill;
    }


    public void insertAllUserBills(List<RoomMate> rs, int bs) {
        BillsDao bd = new BillsDao();
        Bills b = bd.getBills(bs);
        UserBillsDao ubd = new UserBillsDao();
        log.info("59" + b);
        for(RoomMate r : rs) {
            UserBills ub = new UserBills(b.getId(), r.getId(), b.getBill_amt()/rs.size()
                    , b.getDue_date(), 0, false);
            UserBills inserted = ubd.insertNewUserBills(ub);
            log.info(inserted);
        }
    }

}
