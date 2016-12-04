package com.tmorency.edu.servlets;

import com.tmorency.edu.controller.BillsRetriever;
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
@WebServlet(name = "Bills", urlPatterns = { "/admin/bill" } )

public class BillsServlet extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BillsRetriever br = new BillsRetriever(req.getUserPrincipal().getName());

        req.setAttribute("bills", br.retrieveRentalsBills());
        req.setAttribute("userBills", br.getUserBills());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/Bills" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
