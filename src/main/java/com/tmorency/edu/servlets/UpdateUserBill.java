package com.tmorency.edu.servlets;

import com.tmorency.edu.Daos.UserBillsDao;
import com.tmorency.edu.entity.UserBills;
import org.apache.log4j.Logger;

import javax.persistence.criteria.CriteriaBuilder;
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
@WebServlet(name = "ubUp", urlPatterns = { "/admin/ubUp" } )
public class UpdateUserBill extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserBillsDao ubd = new UserBillsDao();
        UserBills ub = ubd.getUserBills(Integer.valueOf(req.getParameter("ubid")));
        log.info(ub);

        int paid = 0;

        if(ub.getPaid_amt() != 0) {
            paid = ub.getPaid_amt();
        }



        ub.setPaid_amt(Integer.valueOf(req.getParameter("amt")) + paid);
        if(ub.getPaid_amt() >= ub.getSplit_amt()) {
            ub.setPaid(true);
        }
        log.info(ub.getPaid_amt());
        ubd.updateUB(ub);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/bill");
        dispatcher.forward(req, resp);
    }
}
