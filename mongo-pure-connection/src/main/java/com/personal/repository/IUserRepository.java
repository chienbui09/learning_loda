package com.personal.repository;

import com.personal.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    Optional<User> findOneByFullName(String fullName);
    List<User> findByFullName(String fullName);
    List<User> findByfullNameTextSearch(String fullName);

    List<User> findByGender(String gender);

}
