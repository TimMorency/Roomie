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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tim on 12/5/2016.
 */
@WebServlet(name = "UserChores", urlPatterns = { "/admin/userchore" } )
public class UserChoresServlet extends HttpServlet{
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("hello");
        ChoreCreator cc = new ChoreCreator(req.getUserPrincipal().getName());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dueDate = null;
        try {
            dueDate = formatter.parse(req.getParameter("DueDate1"));
        } catch(ParseException e) {
            e.printStackTrace();
        }

        cc.insertUserChores(Integer.valueOf(req.getParameter("chore")), Integer.valueOf(req.getParameter("roommate")),
                dueDate);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/chore");
        dispatcher.forward(req, resp);


    }
}
