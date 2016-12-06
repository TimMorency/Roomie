package com.tmorency.edu.servlets;

import com.tmorency.edu.controller.ChoreCreator;

import javax.persistence.criteria.CriteriaBuilder;
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
 * Created by Tim on 12/4/2016.
 */
@WebServlet(name = "userChoreIn", urlPatterns = { "/admin/userChoreIn" } )
public class InsertUserChoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ChoreCreator cc = new ChoreCreator(req.getUserPrincipal().getName());

        req.setAttribute("users", cc.returnRoomMates());
        req.setAttribute("chores", cc.returnAllChores());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/ChoreAssignment" +
                ".jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

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
