package com.example.scrollablelist;

public class Applicant {
    String name;
    String email;
    int image;

    public Applicant(String name, String email, int image) {
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getImage() {
        return image;
    }
}
