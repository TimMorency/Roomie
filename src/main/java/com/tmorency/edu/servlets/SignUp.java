package com.tmorency.edu.servlets;

import com.tmorency.edu.controller.SignUpController;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tim on 11/1/2016.
 */

@WebServlet(name = "SignUpUser", urlPatterns = { "/signUp" } )

public class SignUp extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-mm-dd");
        Date leaseStart = null;
        Date leaseEnd = null;
        try {
            leaseStart = formatter.parse(req.getParameter("LeaseStart"));
            leaseEnd = formatter.parse(req.getParameter("LeaseEnd"));
        } catch(ParseException e) {
            e.printStackTrace();
        }

        int rentalPass = 0;
        if(req.getParameter("RentalId") == null || req.getParameter("RentalId") == "") {
            rentalPass = 0;
        } else {
            rentalPass = Integer.valueOf(req.getParameter("RentalId"));
        }

        int rentAmount = 0;
        if (req.getParameter("Rent") == null || req.getParameter("Rent") == "") {
            rentAmount = 0;
        } else {
            rentAmount = Integer.valueOf(req.getParameter("Rent"));
        }

        SignUpController suc = new SignUpController();
        suc.signUpRentalCheck(req.getParameter("Address"), req.getParameter("City"),
                req.getParameter("State"), req.getParameter("Zip"), leaseStart,
                leaseEnd, rentAmount,
                req.getParameter("FirstName"), req.getParameter("LastName"), req.getParameter("Email1"),
                req.getParameter("Phone"), rentalPass, req.getParameter("UserName"),
                req.getParameter("Password"));

        resp.sendRedirect("/admin/login.jsp");
    }
}