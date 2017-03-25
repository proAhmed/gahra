package com.gahra.ahmed.gahra.model;

/**
 * Created by ahmed on 2/17/2017.
 */
public class CompanyInput {

    private String Name;
    private String Description;
    private String Picture;
    private String Phone;
    private String Email;
    private String Website;
    private String Whatsapp;
    private String Facebook;

    public CompanyInput() {
    }

    public CompanyInput(String name, String description, String picture, String phone,
                        String email, String website, String whatsapp, String facebook) {
        Name = name;
        Description = description;
        Picture = picture;
        Phone = phone;
        Email = email;
        Website = website;
        Whatsapp = whatsapp;
        Facebook = facebook;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getWhatsapp() {
        return Whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        Whatsapp = whatsapp;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }
}
