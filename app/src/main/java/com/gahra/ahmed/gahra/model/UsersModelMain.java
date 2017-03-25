package com.gahra.ahmed.gahra.model;

import java.util.ArrayList;

/**
 * Created by ahmed on 2/17/2017.
 */
public class UsersModelMain {

    private boolean success;
    private String error;
    private UserModel data;

    public UsersModelMain() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public UserModel getData() {
        return data;
    }

    public void setData(UserModel data) {
        this.data = data;
    }
}
