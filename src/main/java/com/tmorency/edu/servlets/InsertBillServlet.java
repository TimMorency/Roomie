package com.tmorency.edu.servlets;

import com.tmorency.edu.Daos.BillsDao;
import org.apache.log4j.Logger;

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
 * Created by Tim on 12/3/2016.
 */
@WebServlet(name = "billIn", urlPatterns = { "/admin/billIn" } )

public class InsertBillServlet extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private BillsDao bd;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        bd = new BillsDao();

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-mm-dd");
        Date dueDate = null;

        try {
            dueDate = formatter.parse(req.getParameter("dueDate"));
        } catch(ParseException e) {
            e.printStackTrace();
        }
    }
}
