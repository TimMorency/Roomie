package com.tmorency.edu.controller;

import com.tmorency.edu.Daos.*;
import com.tmorency.edu.entity.Bills;
import com.tmorency.edu.entity.Rental;
import com.tmorency.edu.entity.RoomMate;
import com.tmorency.edu.entity.UserBills;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 12/3/2016.
 */
public class BillCreator {

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


    public void insertAllUserBills(List<RoomMate> rs, Bills b) {
        UserBillsDao ubd = new UserBillsDao();
        for(RoomMate r : rs) {
            UserBills ub = new UserBills(b.getId(), r.getId(), b.getBill_amt()/rs.size()
                    , b.getDue_date(), 0, false);
            ubd.insertNewUserBills(ub);
        }
    }

}
