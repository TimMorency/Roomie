package com.tmorency.edu.servlets;

import com.tmorency.edu.Daos.UserChoresDao;
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
 * Created by Tim on 12/6/2016.
 */
@WebServlet(name = "ucUp", urlPatterns = { "/admin/ucUp" } )
public class UpdateUserChore extends HttpServlet{

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserChoresDao ucd = new UserChoresDao();

        log.info(req.getParameter("complete"));

        Boolean b = false;
        if(req.getParameter("complete") != null) {
            log.info(req.getParameter("complete"));
            b = true;
        }
        log.info(b);

        UserChores uc = ucd.getUserChores(Integer.valueOf(req.getParameter("ucid")));
        uc.setCompleted(b);
        log.info(uc);
        ucd.updateUserChore(uc);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/chore");
        dispatcher.forward(req, resp);
    }
}
