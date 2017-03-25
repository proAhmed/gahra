package com.gahra.ahmed.gahra.model;

import java.util.ArrayList;

/**
 * Created by ahmed on 2/17/2017.
 */
public class CompaniesMain {

    private boolean success;
    private String error;
    private ArrayList<CompaniesModel> data;

    public CompaniesMain() {
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

    public ArrayList<CompaniesModel> getData() {
        return data;
    }

    public void setData(ArrayList<CompaniesModel> data) {
        this.data = data;
    }
}
