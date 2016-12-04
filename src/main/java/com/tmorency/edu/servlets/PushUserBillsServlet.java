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
            if(req.getParameter(String.valueOf(r.getId())) == "true") {
                selected.add(r);
            }
        }
        br.insertAllUserBills(selected, (Bills) req.getAttribute("bill"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/Bills" +
                ".jsp");
        dispatcher.forward(req, resp);

    }
}
