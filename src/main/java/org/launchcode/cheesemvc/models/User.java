package org.launchcode.cheesemvc.models;

import java.util.Date;

public class User {

    private String user;
    private String email;
    private String password;
    private int userId;
    private static int nextUserId = 1;
    private Date dateJoined;

    // Constructor
    public User() {
        userId = nextUserId;
        nextUserId++;
        dateJoined = new Date();
    }

    // Getter and setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDateJoined() {
        return dateJoined;
    }
}

