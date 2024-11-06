package com.example.testservice.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserData {

    @NotBlank(message = "Name is required.")
    String name;
    @Email(message = "Email id is invalid.")
    String email;
    @Size(min = 8, message = "Password must be at least 8 characters long")
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


    public UserData(
            String name, String email, String password) {

        this.name = name;
        this.email = email;
        this.password = password;

    }

}
