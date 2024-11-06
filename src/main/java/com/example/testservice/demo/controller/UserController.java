package com.example.testservice.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.testservice.demo.dto.CommonResponse;
import com.example.testservice.demo.dto.UserData;
import com.example.testservice.demo.service.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    UserService myService;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse> create(@RequestBody @Valid UserData data, BindingResult result) {

        if (result.hasErrors()) {
            Optional<ObjectError> error = result.getAllErrors().stream().findFirst();
            return new ResponseEntity<CommonResponse>(
                    new CommonResponse(false, "Error: " + error.get().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        } else {
            CommonResponse response = myService.signup(data);
            return new ResponseEntity<CommonResponse>(response, HttpStatus.OK);
        }

    }

    @GetMapping("/users")
    public List<UserData> getUsers() {
        return myService.getUsers();
    }
    

}
