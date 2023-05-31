package com.example.blackhat.models;

public class Person {
    private String telephoneNumber;
    private String name;

    public Person(String telephoneNumber, String name) {
        this.telephoneNumber = telephoneNumber;
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
