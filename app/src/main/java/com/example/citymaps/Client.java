package com.example.citymaps;

import java.io.Serializable;

public class Client implements Serializable {
    private String Name;
    private String Surname;
    private String Mail;

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
    public void setSurname(String surname) {
        Surname = surname;
    }
    public void setMail(String mail) {
        Mail = mail;
    }

    public String getSurname() {
        return Surname;
    }
    public String getMail() {
        return Mail;
    }
}
