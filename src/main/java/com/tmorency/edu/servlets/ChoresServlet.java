package com.tmorency.edu.servlets;

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
 * Created by Tim on 12/1/2016.
 */
@WebServlet(name = "Chores", urlPatterns = { "/admin/chore" } )

public class ChoresServlet extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HomeRetriever hr = new HomeRetriever(req.getUserPrincipal().getName());
        req.setAttribute("chores", hr.rentalsChores());
        req.setAttribute("uChores", hr.getUserChores());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/Chores" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
