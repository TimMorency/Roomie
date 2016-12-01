package com.tmorency.edu.controller;

import com.tmorency.edu.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 11/30/2016.
 */
public class HomeRetriever {

    private RoomMateDao rd;
    private RentalDao rentd;
    private BillsDao bd;
    private ChoresDao cd;
    private UserChoresDao ucd;
    public String name;
    public Rental rent;

    public HomeRetriever(String uName) {
        name = uName;
        rd = new RoomMateDao();
        rentd = new RentalDao();
        bd = new BillsDao();
        cd = new ChoresDao();
        ucd = new UserChoresDao();
    }

    public Rental usersRental() {
        List<RoomMate> r = rd.searchRoomMates("user_name_fk", name);
        RoomMate roomie = r.get(0);
        rent = rentd.getRental(roomie.getRentalId());
        return rent;
    }

    public List<Bills> rentalsBills() {
        return bd.searchBills("rentalId", rent.getId());
    }

    public List<Chores> rentalsChores() {
        List<RoomMate> r = rd.searchRoomMates("user_name_fk", name);
        RoomMate roomie = r.get(0);
        List<Chores> cs = new ArrayList<Chores>();
        cs = cd.searchChores("rental_id", roomie.getRentalId());
        return cs;
    }

    public List<UserChores> getUserChores() {
        List<RoomMate> r = rd.searchRoomMates("user_name_fk", name);
        RoomMate roomie = r.get(0);
        List<UserChores> ucs = new ArrayList<UserChores>();
        ucs = ucd.searchUserChoress("roommate_id", roomie.getId());
        return ucs;
    }

}
