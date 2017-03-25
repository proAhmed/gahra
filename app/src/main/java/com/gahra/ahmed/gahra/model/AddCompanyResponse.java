package com.gahra.ahmed.gahra.model;

/**
 * Created by ahmed on 2/17/2017.
 */
public class AddCompanyResponse {
    private int ID;
    private String Message;

    public AddCompanyResponse() {
    }

    public AddCompanyResponse(int ID, String message) {
        this.ID = ID;
        Message = message;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
