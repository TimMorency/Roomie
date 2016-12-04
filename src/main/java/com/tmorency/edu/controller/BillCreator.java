package com.tmorency.edu.controller;

import com.tmorency.edu.Daos.BillsDao;
import com.tmorency.edu.Daos.RentalDao;
import com.tmorency.edu.Daos.RoomMateDao;
import com.tmorency.edu.Daos.UsersDao;
import com.tmorency.edu.entity.Bills;
import com.tmorency.edu.entity.Rental;
import com.tmorency.edu.entity.RoomMate;

import java.util.List;

/**
 * Created by Tim on 12/3/2016.
 */
public class BillCreator {

    public BillsDao bd;
    public UsersDao ud;
    public RentalDao rd;
    public RoomMateDao rmd;
    public Bills insertedBill;
    public String uName;

    public BillCreator(String userName, Bills createdBill) {
        bd = new BillsDao();
        ud = new UsersDao();
        rd = new RentalDao();
        rmd = new RoomMateDao();
        insertedBill = createdBill;
        uName = userName;
    }

    public BillCreator() {
    }

    public List<RoomMate> getAllOtherRoomMates() {
        return null;
    }
    public Rental getRental() {
        return null;
    }
    public Bills insertBill() {
        return null;
    }


}
