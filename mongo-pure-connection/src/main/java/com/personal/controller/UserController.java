package com.personal.controller;

import com.personal.entity.User;
import com.personal.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private IUserService userService;
    @GetMapping("/{fullName}")
    public User getUsersByFullname(@PathVariable String fullName){
        return userService.getUserByfullName(fullName);
    }

    @GetMapping("/search/{fullName}")
    public List<User> getUserByFullNameSearch(@PathVariable String fullName){
        return userService.getUserByTextSearch(fullName);
    }

}
