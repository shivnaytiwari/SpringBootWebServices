package com.example.testservice.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String email;
    String password;

    public int getId(){
        return id;
    }


    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User( String name,String email,String password) {
        this.name = name;
        this.email=email;
        this.password=password;
    }
}