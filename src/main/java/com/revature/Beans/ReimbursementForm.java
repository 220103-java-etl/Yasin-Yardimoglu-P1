package com.revature.Beans;

import java.sql.Timestamp;

public class ReimbursementForm {

    private int reimbursementId;
    private int employeeId;
    private String eventDate;
    private String eventTime;
    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;
    private String description;
    private float eventCost;
    private String gradingFormat;
    private String eventType;
    private String grade;
    private String status;
    private Timestamp eventTimestamp;

    public ReimbursementForm() {
    }

    public ReimbursementForm(int employeeId, String eventDate, String eventTime, String streetAddress, String city, String state, String zipcode, String description, float eventCost, String gradingFormat, String eventType) {
        this.employeeId = employeeId;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.description = description;
        this.eventCost = eventCost;
        this.gradingFormat = gradingFormat;
        this.eventType = eventType;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getEventCost() {
        return eventCost;
    }

    public void setEventCost(float eventCost) {
        this.eventCost = eventCost;
    }

    public String getGradingFormat() {
        return gradingFormat;
    }

    public void setGradingFormat(String gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(Timestamp eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    @Override
    public String toString() {
        return "ReimbursementForm{" +
                "reimbursementId=" + reimbursementId +
                ", employeeId=" + employeeId +
                ", eventDate='" + eventDate + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", description='" + description + '\'' +
                ", eventCost=" + eventCost +
                ", gradingFormat='" + gradingFormat + '\'' +
                ", eventType='" + eventType + '\'' +
                ", grade='" + grade + '\'' +
                ", status='" + status + '\'' +
                ", eventTimestamp=" + eventTimestamp +
                '}';
    }
}
