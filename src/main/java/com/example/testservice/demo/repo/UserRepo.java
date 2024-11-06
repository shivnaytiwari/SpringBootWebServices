package com.example.testservice.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testservice.demo.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    boolean existsUserByEmail(String email);

}
