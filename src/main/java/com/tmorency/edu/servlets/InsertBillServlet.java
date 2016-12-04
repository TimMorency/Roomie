package com.tmorency.edu.servlets;

import com.tmorency.edu.Daos.BillsDao;
import com.tmorency.edu.controller.BillCreator;
import com.tmorency.edu.controller.BillsRetriever;
import com.tmorency.edu.entity.Bills;
import com.tmorency.edu.entity.Rental;
import com.tmorency.edu.entity.RoomMate;
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
import java.util.List;

/**
 * Created by Tim on 12/3/2016.
 */
@WebServlet(name = "billIn", urlPatterns = { "/admin/billIn" } )

public class InsertBillServlet extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dueDate = null;
        try {
            dueDate = formatter.parse(req.getParameter("DueDate1"));
        } catch(ParseException e) {
            e.printStackTrace();
        }
        BillCreator br = new BillCreator(req.getUserPrincipal().getName());
        List<RoomMate> rms = br.getAllOtherRoomMates();
        Rental r = br.getRental();

        Bills b = new Bills(req.getParameter("billName"), Integer.valueOf(req.getParameter("amt")), dueDate, r.getId());

        Bills passedBill = br.insertBill(b);

        req.setAttribute("users", rms);
        req.setAttribute("rental", r);
        req.setAttribute("bill", passedBill);


        RequestDispatcher rd = req.getRequestDispatcher("/admin/BillSplitter.jsp");
        rd.forward(req,resp);

    }
}
