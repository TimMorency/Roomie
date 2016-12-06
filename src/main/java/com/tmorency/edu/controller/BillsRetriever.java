package com.tmorency.edu.controller;

import com.tmorency.edu.Daos.BillsDao;
import com.tmorency.edu.Daos.RentalDao;
import com.tmorency.edu.Daos.RoomMateDao;
import com.tmorency.edu.Daos.UserBillsDao;
import com.tmorency.edu.entity.Bills;
import com.tmorency.edu.entity.Rental;
import com.tmorency.edu.entity.RoomMate;
import com.tmorency.edu.entity.UserBills;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 11/30/2016.
 */
public class BillsRetriever {
    private final Logger log = Logger.getLogger(this.getClass());

    private BillsDao bd;
    private RentalDao rd;
    private RoomMateDao rmd;
    private UserBillsDao ubd;
    private List<RoomMate> roomie;
    private RoomMate room;
    private Rental rent;

    public BillsRetriever(String uName) {
        bd = new BillsDao();
        rd = new RentalDao();
        rmd = new RoomMateDao();
        ubd = new UserBillsDao();
        List<RoomMate> roomie = rmd.searchRoomMates("user_name_fk", uName);
        room = roomie.get(0);
        log.info(room.getLastName());
        log.info(room.getRentalId());
        rent = rd.getRental(room.getRentalId());
    }

    public List<Bills> retrieveRentalsBills() {
        List<Bills> bills = new ArrayList<Bills>();
        log.info(rent.getId());
        bills = bd.searchBills("rentalId", rent.getId());
        return bills;
    }

    public List<UserBills> getUserBills() {
        List<Bills> bills = new ArrayList<Bills>();
        bills = bd.searchBills("rentalId", rent.getId());
        List<Integer> billIds = new ArrayList<Integer>();
        for(Bills b : bills) {
            billIds.add(b.getId());
        }
        List<UserBills> userBills = new ArrayList<UserBills>();
        if(billIds.size() >0) {
            userBills = ubd.searchInUserBills(billIds);
        }
        List<UserBills> nonPaid = new ArrayList<UserBills>();
        for(UserBills ub : userBills) {
            if(ub.isPaid() == false && ub.getRoommate_id() == room.getId()) {
                nonPaid.add(ub);
            }
        }
        return nonPaid;
    }




}
