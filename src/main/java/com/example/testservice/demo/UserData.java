package com.example.testservice.demo;

public class UserData {

    int id;
    String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public UserData(int id,
            String name) {

        this.name = name;
        this.id = id;

    }

}
