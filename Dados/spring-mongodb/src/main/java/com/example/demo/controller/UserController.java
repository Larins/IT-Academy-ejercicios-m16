package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserAuthentication;

@RestController
public class UserController {

    @PostMapping("user")
    public UserAuthentication Login(
    		@RequestParam("user") String username, 
    		@RequestParam("password") String pwd) {
        return null;
    }
}