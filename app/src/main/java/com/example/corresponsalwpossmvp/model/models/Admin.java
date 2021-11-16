package com.example.corresponsalwpossmvp.model.models;

public class Admin {
    String id;
    String mailAdmin = "admin@wposs.com";
    String passwordaAdmin = "123456";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMailAdmin() {
        return mailAdmin;
    }

    public void setMailAdmin(String mailAdmin) {
        this.mailAdmin = mailAdmin;
    }

    public String getPasswordaAdmin() {
        return passwordaAdmin;
    }

    public void setPasswordaAdmin(String passwordaAdmin) {
        this.passwordaAdmin = passwordaAdmin;
    }
}
