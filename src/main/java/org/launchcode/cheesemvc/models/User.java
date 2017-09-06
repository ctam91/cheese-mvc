package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    @NotNull
    @Size(min=5,max=15)
    private String user;

    @Email
    private String email;

    @NotNull
    @Size(min=6, message = "Password must be greater than six characters")
    private String password;

    @NotNull
    @Size(min=6, message = "Passwords do not match")
    private String verifyPassword;

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
        checkPassword();
    }

    public int getUserId() {
        return userId;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    // Checks if password and verifyPassword are the same. If not, then set verifyPassword to null.
    private void checkPassword(){
        if(password != null && verifyPassword != null && !password.equals(verifyPassword)){
            verifyPassword = null;
        }
    }
}

