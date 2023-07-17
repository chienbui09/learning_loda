package com.personal.service;

import com.personal.entity.User;

import java.util.List;

public interface IUserService {
    User getUserByfullName(String fullName);

    List<User> getUsersByfullName(String fullName);

    List<User> getUserByGender(String gender);

    List<User> getUserByTextSearch(String fullName);
}
