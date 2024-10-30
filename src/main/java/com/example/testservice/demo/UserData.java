package com.example.testservice.demo;

public class UserData {

    int id;
    String name;
    String email;
    String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public UserData(int id,
            String name, String email, String password) {

        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;

    }

}
