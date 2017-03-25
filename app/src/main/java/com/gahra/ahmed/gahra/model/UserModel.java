package com.gahra.ahmed.gahra.model;

/**
 * Created by ahmed on 2/17/2017.
 */
public class UserModel {
    private int ID;
    private String FullName;
    private String UserName;
    private String Picture;
    private String Email;
    private String Mobile;
    private String IsActive;
    private String CreatedDate;
    private String ModifiedDate;
    private String LastLogIn;
    private String LastPassChanged;
    private int State;
    private String token;

    public UserModel() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
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

    public String getIsActive() {
        return IsActive;
    }

    public void setIsActive(String isActive) {
        IsActive = isActive;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public String getLastLogIn() {
        return LastLogIn;
    }

    public void setLastLogIn(String lastLogIn) {
        LastLogIn = lastLogIn;
    }

    public String getLastPassChanged() {
        return LastPassChanged;
    }

    public void setLastPassChanged(String lastPassChanged) {
        LastPassChanged = lastPassChanged;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
