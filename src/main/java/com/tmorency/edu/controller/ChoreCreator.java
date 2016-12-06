package com.tmorency.edu.controller;

import com.tmorency.edu.Daos.ChoresDao;
import com.tmorency.edu.Daos.RoomMateDao;
import com.tmorency.edu.Daos.UserChoresDao;
import com.tmorency.edu.entity.Chores;
import com.tmorency.edu.entity.RoomMate;
import com.tmorency.edu.entity.UserChores;

import java.util.Date;
import java.util.List;

/**
 * Created by Tim on 12/4/2016.
 */
public class ChoreCreator {
    private RoomMateDao rmd;
    private ChoresDao cd;
    private String userName;

    public ChoreCreator(String uName) {
        rmd = new RoomMateDao();
        cd = new ChoresDao();
        userName = uName;
    }

    public ChoreCreator() {
    }

    public Chores insertChore(String name, String descrip) {

        List<RoomMate> rm = rmd.searchRoomMates("user_name_fk", userName);
        RoomMate roomie = rm.get(0);

        Chores c = new Chores(name, descrip, roomie.getRentalId());
        Chores inserted = cd.insertNewChores(c);

        return inserted;
    }

    public List<Chores> returnAllChores() {
        List<RoomMate> rms = rmd.searchRoomMates("user_name_fk", userName);
        RoomMate roomie = rms.get(0);
        List<Chores> cs = cd.searchChores("rentalId", roomie.getRentalId());
        return cs;
    }

    public List<RoomMate> returnRoomMates() {
        List<RoomMate> rms = rmd.searchRoomMates("user_name_fk", userName);
        RoomMate roomie = rms.get(0);
        List<RoomMate> returners = rmd.searchRoomMatesInt("rentalId", roomie.getRentalId());
        return returners;
    }


    public void insertUserChores(int choreid, int roommateid, Date assignedDate) {
        UserChores uc = new UserChores(choreid, roommateid, assignedDate, false);
        UserChoresDao ucd = new UserChoresDao();
        ucd.insertNewUserChores(uc);
    }
}
