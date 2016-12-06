package com.tmorency.edu.servlets;

import com.tmorency.edu.Daos.BillsDao;
import com.tmorency.edu.Daos.UserBillsDao;
import com.tmorency.edu.entity.Bills;
import com.tmorency.edu.entity.UserBills;
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
@WebServlet(name = "ub", urlPatterns = { "/admin/ub" } )
public class SingleUserBill extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserBillsDao ubd =  new UserBillsDao();
        BillsDao bd = new BillsDao();

        UserBills ub  = ubd.getUserBills(Integer.valueOf(req.getParameter("userBill")));

        Bills b = bd.getBills(ub.getBill_id());

        req.setAttribute("bill", b);
        req.setAttribute("ubill", ub);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/UserBill.jsp");
        dispatcher.forward(req, resp);
    }
}
