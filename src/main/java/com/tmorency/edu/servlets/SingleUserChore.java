package com.tmorency.edu.servlets;

import com.tmorency.edu.Daos.ChoresDao;
import com.tmorency.edu.Daos.UserChoresDao;
import com.tmorency.edu.entity.Chores;
import com.tmorency.edu.entity.UserChores;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tim on 12/5/2016.
 */
@WebServlet(name = "uc", urlPatterns = { "/admin/uc" } )
public class SingleUserChore extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UserChoresDao ubd =  new UserChoresDao();
        ChoresDao bd = new ChoresDao();

        UserChores ub  = ubd.getUserChores(Integer.valueOf(req.getParameter("userchore")));

        Chores b = bd.getChores(ub.getChore_id());

        req.setAttribute("chore", b);
        req.setAttribute("uchore", ub);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/UserChore.jsp");
        dispatcher.forward(req, resp);
    }
}
