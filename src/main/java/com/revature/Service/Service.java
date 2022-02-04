package com.revature.Service;


import com.revature.Beans.Employee;
import com.revature.Beans.ReimbursementForm;
import com.revature.DAO.DAO;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;


public class Service {

    DAO dao = new DAO();

//    public void associateMenu(Employee employee, String menuOption) throws SQLException {
////        Scanner sc = new Scanner(System.in);
////        System.out.println("Type a number associated with your desired action:");
////        System.out.println("1: Submit a Reimbursement Form");
////        System.out.println("2: View Reimbursement(s)");
////        System.out.println("3: Logout");
////        menuOption = sc.next();
//        switch(menuOption) {
//            case "1":
//                dao.submitToDatabase(receiveReimbursementInformation(employee));
//                break;
//            case "2":
//                System.out.println(dao.retrieveReimbursementByEmployeeId(employee.getEmployeeId()));
//                break;
//            case "3":
//                employeeResetData(employee);
//                //employeeLogin();
//                break;
//        }
////        sc.close();
//    }

//    public void employeeResetData(Employee employee) {
//        employee = null;
//    }

    public Employee employeeLogin(String email, String password) throws SQLException {
        Employee employee = null;

            employee = dao.retrieveEmployeeByLoginInfo(email, password);

        return employee;
    }

    public boolean submitReimbursementForm(ReimbursementForm reimbursementForm) throws SQLException {



        reimbursementForm.setStatus("submitted");

        reimbursementForm.setEventTimestamp(Timestamp.from(Instant.now()));

        return dao.submitReimFormToDatabase(reimbursementForm);
    }
}
