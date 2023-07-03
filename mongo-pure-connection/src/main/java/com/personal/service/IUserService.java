package com.personal.service;

import com.personal.entity.User;

import java.util.List;

public interface IUserService {
    User getUserByfullName(String fullName);

    List<User> getUserByAge(String gender);

    List<User> getUserByTextSearch(String fullName);
}
