package com.personal.controller;

import com.personal.entity.User;
import com.personal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{fullName}")
    public User getUserByFullName(@PathVariable String fullName) {
        return userService.getUserByfullName(fullName);
    }

    @GetMapping("/list/{fullName}")
    public List<User> getUsersByFullName(@PathVariable String fullName) {
        return userService.getUsersByfullName(fullName);
    }

    @GetMapping("/gender/{gender}")
    public List<User> getUsersByGender(@PathVariable("gender") String gender) {
        return userService.getUserByGender(gender);
    }

    @GetMapping("/search/{fullName}")
    public List<User> getUserByFullNameSearch(@PathVariable("fullName") String fullName) {
        return userService.getUserByTextSearch(fullName);
    }

}
