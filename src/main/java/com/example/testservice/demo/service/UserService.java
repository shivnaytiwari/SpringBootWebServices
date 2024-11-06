package com.example.testservice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testservice.demo.Entity.User;
import com.example.testservice.demo.dto.CommonResponse;
import com.example.testservice.demo.dto.UserData;
import com.example.testservice.demo.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public ArrayList<UserData> getUsers() {

        List<User> users = userRepo.findAll();

        ArrayList<UserData> list = new ArrayList<>();

        for (User user : users) {
            list.add(new UserData( user.getName(), user.getEmail(),"********"));
        }

        return list;
    }

    public CommonResponse signup(UserData user) {

        try {

            boolean exists = userRepo.existsUserByEmail(user.getEmail());
            if (exists) {
                return new CommonResponse(false, "User email is already registered!!");   
            }
            User userData = new User(user.getName(), user.getEmail(), user.getPassword());
            userRepo.save(userData);
            return new CommonResponse(true, "User signup successfull");
        } catch (Exception e) {
            return new CommonResponse(false, "Failed to save user data e: " + e.getMessage());
        }
    }

}
