package com.tmorency.edu.servlets;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tim on 12/3/2016.
 */

@WebServlet(name = "userBillIn", urlPatterns = { "/admin/usersBillIn" } )

public class InsertUserBillServlet extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("users", req.getAttribute("roommates"));
        req.setAttribute("rental", req.getAttribute("rental"));
        req.setAttribute("bill", req.getAttribute("bill"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/BillSplitter" +
            ".jsp");
        dispatcher.forward(req, resp);
}


}
