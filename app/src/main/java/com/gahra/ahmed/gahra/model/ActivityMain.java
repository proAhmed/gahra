package com.gahra.ahmed.gahra.model;

import java.util.ArrayList;

/**
 * Created by ahmed on 2/17/2017.
 */
public class ActivityMain {

   private boolean success;
   private String error;
   private ArrayList<ActivityMain> data;

    public ActivityMain() {
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

    public ArrayList<ActivityMain> getData() {
        return data;
    }

    public void setData(ArrayList<ActivityMain> data) {
        this.data = data;
    }
}
