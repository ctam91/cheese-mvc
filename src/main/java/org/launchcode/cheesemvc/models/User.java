package org.launchcode.cheesemvc.models;

public class User {

    private String user;
    private String email;
    private String password;

    // Constructor
    public User() {
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
}

