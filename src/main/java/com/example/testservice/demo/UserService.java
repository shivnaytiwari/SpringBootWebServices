package com.example.testservice.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testservice.demo.repo.UserRepo;
import com.example.testservice.CommonResponse;
import com.example.testservice.demo.bean.User;

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
            list.add(new UserData(user.getId(), user.getName()));
        }

        return list;
    }

    public CommonResponse signup(UserData user) {

        try {
            User first = new User(user.name,user.email,user.password);
            userRepo.save(first);
            return new CommonResponse(true, "User signup successfull");
            // return "success";
        } catch (Exception e) {
            return new CommonResponse(false, "Failed to save user data e: " + e.getMessage());
            // return "fsiled";
        }
    }

}
