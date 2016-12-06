package com.tmorency.edu.servlets;

import com.tmorency.edu.controller.ChoreCreator;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tim on 12/4/2016.
 */
@WebServlet(name = "choreIn", urlPatterns = { "/admin/choreIn" } )
public class InsertChoreServlet extends HttpServlet{

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ChoreCreator cc = new ChoreCreator(req.getUserPrincipal().getName());

        cc.insertChore(req.getParameter("choreName"), req.getParameter("choreDescription"));

        RequestDispatcher rd = req.getRequestDispatcher("/admin/chore");
        rd.forward(req,resp);

    }
}
