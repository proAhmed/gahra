package com.gahra.ahmed.gahra.model;

import java.util.ArrayList;

/**
 * Created by ahmed on 2/17/2017.
 */
public class OfferModelMain {

    private boolean success;
    private String error;
    private ArrayList<OfferModel> data;

    public OfferModelMain() {
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

    public ArrayList<OfferModel> getData() {
        return data;
    }

    public void setData(ArrayList<OfferModel> data) {
        this.data = data;
    }
}
