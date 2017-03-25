package com.gahra.ahmed.gahra.model;

/**
 * Created by ahmed on 2/17/2017.
 */
public class AddCompanyMain {
    private boolean success;
    private Object error;
    AddCompanyResponse data;

    public AddCompanyMain() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public AddCompanyResponse getData() {
        return data;
    }

    public void setData(AddCompanyResponse data) {
        this.data = data;
    }
}
