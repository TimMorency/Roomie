package com.tmorency.edu.servlets;

import com.tmorency.edu.controller.BillsRetriever;
import com.tmorency.edu.controller.HomeRetriever;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tim on 11/30/2016.
 */
@WebServlet(name = "Home", urlPatterns = { "/admin/home" } )

public class HomeServlet extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HomeRetriever hr = new HomeRetriever(req.getUserPrincipal().getName());
        req.setAttribute("rental", hr.usersRental());
        req.setAttribute("bills", hr.rentalsBills());
        req.setAttribute("chores", hr.rentalsChores());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/login" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
