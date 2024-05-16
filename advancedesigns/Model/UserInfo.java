package com.example.advancedesigns.Model;

public class UserInfo {

    private String Name;
    private String Contact;
    private String Mail;
    private String password;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo(String name, String contact, String mail, String password) {
        Name = name;
        Contact = contact;
        Mail = mail;
        this.password = password;
    }

    public UserInfo() {
    }
}
