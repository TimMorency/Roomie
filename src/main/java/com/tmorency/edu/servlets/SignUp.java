package com.tmorency.edu.servlets;

import com.tmorency.edu.controller.RoomMateDao;
import com.tmorency.edu.controller.UsersDao;
import com.tmorency.edu.entity.RoomMate;
import com.tmorency.edu.entity.Users;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tim on 11/1/2016.
 */

@WebServlet(name = "SignUpUser", urlPatterns = { "/signUp" } )

public class SignUp extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        RoomMate newRoomMate = new RoomMate(req.getParameter("FirstName"),
                req.getParameter("LastName"),req.getParameter("Email1"), req.getParameter("Phone"),
                Integer.parseInt(req.getParameter("RentalId")), req.getParameter("UserName"));
        Users newU = new Users(req.getParameter("UserName"), req.getParameter("Password"));
        log.info(req.getParameter("RentalId"));
        UsersDao ud = new UsersDao();
        ud.insertUser(newU);
        RoomMateDao rmd = new RoomMateDao();
        rmd.insertNewRoomMate(newRoomMate);
    }
}