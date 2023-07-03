package com.example.controller;

import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {
    UserService userService;

    @GetMapping(name = "/users")
    public void getAllUser(){
        userService.findAll();
    }

}
