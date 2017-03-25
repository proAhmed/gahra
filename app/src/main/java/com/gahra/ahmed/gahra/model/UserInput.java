package com.gahra.ahmed.gahra.model;

/**
 * Created by ahmed on 2/17/2017.
 */
public class UserInput {

    private String FullName;
    private String UserName;
    private String Password;
    private String Email;
    private String Mobile;
    private String Picture;

    public UserInput() {
    }

    public UserInput(String fullName, String userName, String password, String email, String mobile, String picture) {
        FullName = fullName;
        UserName = userName;
        Password = password;
        Email = email;
        Mobile = mobile;
        Picture = picture;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }
}
