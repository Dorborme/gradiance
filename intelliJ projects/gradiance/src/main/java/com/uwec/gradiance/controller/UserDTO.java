package com.uwec.gradiance.controller;

public class UserDTO {
    private String email;
    private String passwordHash;
    private String studentId;
    private int adminRights;

    public UserDTO() {}

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setAdminRights(int adminRights) {this.adminRights = adminRights; }

    public int getAdminRights() {return adminRights;}

    public void setStudentId(String studentId) {this.studentId = studentId;}

    public String getStudentId() {return studentId;};
}
