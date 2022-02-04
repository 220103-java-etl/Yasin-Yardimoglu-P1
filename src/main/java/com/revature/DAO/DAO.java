package com.revature.DAO;

import com.revature.Beans.Employee;
import com.revature.Beans.ReimbursementForm;
import com.revature.Util.ConnectionUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    public void updateReimbursementStatus(ReimbursementForm reimbursementForm) throws SQLException {
        String sql = "update reimbursements set status = ? where reimburse_id = ?;";
        try(Connection connection = connectionUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, reimbursementForm.getStatus());
            ps.setInt(2, reimbursementForm.getReimbursementId());

            ps.executeUpdate();
        }
    }

    public Employee retrieveEmployeeByLoginInfo(String email, String password) throws SQLException {
        String sql = "select * from Employees where email = ? and employee_password = ?;";
        Employee employee = new Employee();
        try (Connection connection = connectionUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
                employee.setEmployeeRole(rs.getString("employee_role"));
            } else {
                return null;
            }
        }
        return employee;
    }

    public boolean submitReimFormToDatabase(ReimbursementForm reimbursementForm) throws SQLException {
        String sql = "insert into Reimbursements (event_date, event_time, street_address, city, state, zipcode, description, event_cost, grading_format, event_type, grade, status, event_timestamp, employee_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection connection = connectionUtil.getConnection()) {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, reimbursementForm.getEventDate());
            ps.setString(2, reimbursementForm.getEventTime());
            ps.setString(3, reimbursementForm.getStreetAddress());
            ps.setString(4, reimbursementForm.getCity());
            ps.setString(5, reimbursementForm.getState());
            ps.setString(6, reimbursementForm.getZipcode());
            ps.setString(7, reimbursementForm.getDescription());
            ps.setFloat(8, reimbursementForm.getEventCost());
            ps.setString(9, reimbursementForm.getGradingFormat());
            ps.setString(10, reimbursementForm.getEventType());
            ps.setString(11, reimbursementForm.getGrade());
            ps.setString(12, reimbursementForm.getStatus());
            ps.setTimestamp(13, reimbursementForm.getEventTimestamp());
            ps.setInt(14, reimbursementForm.getEmployeeId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public List<ReimbursementForm> retrieveAllReimbursements() {
        ReimbursementForm reimbursementForm = null;
        List<ReimbursementForm> reimbursementFormList = new ArrayList<>();
        String sql = "SELECT * FROM reimbursements;";
        try (Connection connection = connectionUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reimbursementForm = new ReimbursementForm();
                reimbursementForm.setReimbursementId(rs.getInt("reimburse_id"));
                reimbursementForm.setEventDate(rs.getString("event_date"));
                reimbursementForm.setEventTime(rs.getString("event_time"));
                reimbursementForm.setStreetAddress(rs.getString("street_address"));
                reimbursementForm.setCity(rs.getString("city"));
                reimbursementForm.setState(rs.getString("state"));
                reimbursementForm.setZipcode(rs.getString("zipcode"));
                reimbursementForm.setDescription(rs.getString("description"));
                reimbursementForm.setEventCost(rs.getFloat("event_cost"));
                reimbursementForm.setGradingFormat(rs.getString("grading_format"));
                reimbursementForm.setEventType(rs.getString("event_type"));
                reimbursementForm.setGrade(rs.getString("grade"));
                reimbursementForm.setStatus(rs.getString("status"));
                reimbursementForm.setEventTimestamp(rs.getTimestamp("event_timestamp"));

                reimbursementFormList.add(reimbursementForm);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reimbursementFormList;
    }

    public List<ReimbursementForm> retrieveReimbursementByEmployeeId(int employeeId) {
        List<ReimbursementForm> reimbursementFormList = new ArrayList<>();
        ReimbursementForm reimbursementForm = null;
        String sql = "select * from reimbursements r where employee_id=?;";
        try(Connection connection = connectionUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                reimbursementForm = new ReimbursementForm();
                reimbursementForm.setReimbursementId(rs.getInt("reimburse_id"));
                reimbursementForm.setEventDate(rs.getString("event_date"));
                reimbursementForm.setEventTime(rs.getString("event_time"));
                reimbursementForm.setStreetAddress(rs.getString("street_address"));
                reimbursementForm.setCity(rs.getString("city"));
                reimbursementForm.setState(rs.getString("state"));
                reimbursementForm.setZipcode(rs.getString("zipcode"));
                reimbursementForm.setDescription(rs.getString("description"));
                reimbursementForm.setEventCost(rs.getFloat("event_cost"));
                reimbursementForm.setGradingFormat(rs.getString("grading_format"));
                reimbursementForm.setEventType(rs.getString("event_type"));
                reimbursementForm.setGrade(rs.getString("grade"));
                reimbursementForm.setStatus(rs.getString("status"));
                reimbursementForm.setEventTimestamp(rs.getTimestamp("event_timestamp"));

                reimbursementFormList.add(reimbursementForm);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reimbursementFormList;
    }

    public List<ReimbursementForm> retrieveReimbursementByStatus(String status) {
        ReimbursementForm reimbursementForm = null;
        List<ReimbursementForm> reimbursementFormList = new ArrayList<>();
        String sql ="select * from reimbursements r where status=?;";
        try(Connection connection = connectionUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,status);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursementForm = new ReimbursementForm();
                reimbursementForm.setReimbursementId(rs.getInt("reimburse_id"));
                reimbursementForm.setEventDate(rs.getString("event_date"));
                reimbursementForm.setEventTime(rs.getString("event_time"));
                reimbursementForm.setStreetAddress(rs.getString("street_address"));
                reimbursementForm.setCity(rs.getString("city"));
                reimbursementForm.setState(rs.getString("state"));
                reimbursementForm.setZipcode(rs.getString("zipcode"));
                reimbursementForm.setDescription(rs.getString("description"));
                reimbursementForm.setEventCost(rs.getFloat("event_cost"));
                reimbursementForm.setGradingFormat(rs.getString("grading_format"));
                reimbursementForm.setEventType(rs.getString("event_type"));
                reimbursementForm.setGrade(rs.getString("grade"));
                reimbursementForm.setStatus(rs.getString("status"));
                reimbursementForm.setEventTimestamp(rs.getTimestamp("event_timestamp"));

                reimbursementFormList.add(reimbursementForm);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reimbursementFormList;
    }
}
