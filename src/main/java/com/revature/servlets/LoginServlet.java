package com.revature.servlets;

import com.revature.Beans.Employee;
import com.revature.Service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();
    Service service = new Service();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Employee employee = new Employee();
        System.out.println("EMail: " + email);
        System.out.println("Password: " + password);

        try {
            employee = service.employeeLogin(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String responseBody = objectMapper.writeValueAsString(employee);
        System.out.println("responseBody: " +responseBody);

        response.getWriter().write(objectMapper.writeValueAsString(employee));
        response.sendRedirect("ReimbursementForm.html");

    }

//    public Object getReimbursementsByEmployeeId(HttpServletRequest request) {
//        Customer loggedCustomer = (Customer) request.getSession().getAttribute("loggedCustomer");
//
//        /* If customer is not logged in */
//        if(loggedCustomer == null) {
//            return "login.html";
//        }
//
//        /* Client is requesting the view. */
//        if(request.getParameter("fetch") == null) {
//            return "all-customers.html";
//        } else {
//            /* Client is requesting the list of customers */
//            return CustomerServiceAlpha.getInstance().listAllCustomers();
//        }
//    }


}
