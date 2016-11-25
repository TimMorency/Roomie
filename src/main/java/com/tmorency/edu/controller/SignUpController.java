package com.tmorency.edu.controller;

import org.apache.log4j.Logger;

/**
 * Created by Tim on 11/25/2016.
 */
public class SignUpController {
    private final Logger log = Logger.getLogger(this.getClass());
    public RoomMateDao rmd;
    public RentalDao rd;
    public UsersDao ud;

    public SignUpController() {
        rmd = new RoomMateDao();
        rd = new RentalDao();
        ud = new UsersDao();
    }

    public void signUpRentalCheck() {

    }
}
