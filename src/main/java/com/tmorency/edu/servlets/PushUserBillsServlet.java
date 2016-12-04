package com.tmorency.edu.servlets;

import com.tmorency.edu.Daos.RoomMateDao;
import com.tmorency.edu.controller.BillCreator;
import com.tmorency.edu.entity.Bills;
import com.tmorency.edu.entity.RoomMate;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 12/4/2016.
 */
@WebServlet(name = "userBillIn", urlPatterns = { "/admin/userBillFinish" } )
public class PushUserBillsServlet extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BillCreator br = new BillCreator(req.getUserPrincipal().getName());

        List<RoomMate> returners = br.getAllOtherRoomMates();

        List<RoomMate> selected = new ArrayList<RoomMate>();


        for(RoomMate r : returners) {
            log.info(r.getFirstName());
            log.info(req.getParameter(String.valueOf(r.getId())) );
            if((String) req.getParameter(String.valueOf(r.getId())) != null) {
                log.info(req.getParameter(String.valueOf(r.getId())) );

                selected.add(r);
            }
        }

        log.info(selected);
        log.info(req.getParameter("bill"));

        br.insertAllUserBills(selected, Integer.valueOf(req.getParameter("bill")));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bill");
        dispatcher.forward(req, resp);

    }
}
