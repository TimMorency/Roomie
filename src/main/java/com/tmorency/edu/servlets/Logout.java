package com.tmorency.edu.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

/**
 * Created by Tim on 12/6/2016.
 */
@WebServlet(name = "logout", urlPatterns = { "/admin/logout" } )
public class Logout extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession ses = req.getSession();
        ses.invalidate();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
