package com.tmorency.edu.controller;

import com.tmorency.edu.entity.Rental;
import com.tmorency.edu.entity.RoomMate;
import com.tmorency.edu.entity.UserRoles;
import com.tmorency.edu.entity.Users;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by Tim on 11/25/2016.
 */
public class SignUpController {
    private final Logger log = Logger.getLogger(this.getClass());
    public RoomMateDao rmd;
    public RentalDao rd;
    public UsersDao ud;
    public UserRolesDao urd;

    public RoomMate rm;
    public Rental r;
    public Users u;
    public UserRoles ur;

    public SignUpController() {
        rmd = new RoomMateDao();
        rd = new RentalDao();
        ud = new UsersDao();
        urd = new UserRolesDao();
    }

    public void signUpRentalCheck(String address, String city, String state,
                                  String zip, Date leaseStart, Date leaseEnd,
                                  int rent, String fName, String lName,
                                  String email, String phone, int rentalId,
                                  String userName, String password) {
        r = checkRental(rentalId, address, city, state, zip, leaseStart, leaseEnd,
                rent);
        u = checkUserName(userName, password);
        ur = checkUserRole(userName, "administrator");
        int id = 0;
        if(rentalId <= 0) {
            id = r.getId();
        } else {
            id = rentalId;
        }
        rm = checkRoomMate(fName, lName, email, phone, id, userName);

    }

    public Rental checkRental(int id, String address, String city, String state,
                              String zip, Date leaseStart, Date leaseEnd,
                              int rent) {
        Rental returnRental = new Rental();
        Rental insertReturn = new Rental();
        if(id > 0) {
            returnRental = rd.getRental(id);
            return returnRental;
        } else {
            returnRental.setAddress(address);
            returnRental.setCity(city);
            returnRental.setState(state);
            returnRental.setZip(zip);
            returnRental.setLease_start(leaseStart);
            returnRental.setLease_end(leaseEnd);
            returnRental.setRent(rent);
            insertReturn = rd.insertNewRental(returnRental);
            return insertReturn;
        }
    }
    public RoomMate checkRoomMate(String fName, String lName,
                              String email, String phone, int rentalId,
                              String userName) {

        return rmd.insertNewRoomMate(new RoomMate(fName, lName, email, phone,
                rentalId, userName));
    }
    public Users checkUserName(String userName, String password) {
        return ud.insertUser(new Users(userName, password));
    }
    public UserRoles checkUserRole(String userName, String roleName) {
        return urd.insertUser(new UserRoles(userName, roleName));
    }

}

