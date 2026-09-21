package com.example.scrollablelist;

public class Applicant {
    private final String name;
    private final String email;

    public Applicant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
