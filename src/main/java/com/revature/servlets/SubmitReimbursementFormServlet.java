package com.revature.servlets;

import com.revature.Beans.ReimbursementForm;
import com.revature.Service.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SubmitReimbursementFormServlet", value = "/SubmitReimbursementFormServlet")
public class SubmitReimbursementFormServlet extends HttpServlet {
    Service service = new Service();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReimbursementForm reimbursementForm = new ReimbursementForm(
                Integer.parseInt(request.getParameter("employeeId")),
                request.getParameter("date"),
                request.getParameter("time"),
                request.getParameter("StreetAddress"),
                request.getParameter("City"),
                request.getParameter("State"),
                request.getParameter("zipCode"),
                request.getParameter("Description"),
                Float.parseFloat(request.getParameter("cost")),
                request.getParameter("GradingFormat"),
                request.getParameter("EventType")
        );
        System.out.println("Request: " + reimbursementForm);

        try {
            service.submitReimbursementForm(reimbursementForm);
            response.sendRedirect("ReimbursementReceived.html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
