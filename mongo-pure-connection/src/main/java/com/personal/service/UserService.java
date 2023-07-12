package com.personal.service;

import com.personal.entity.User;
import com.personal.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;
    @Override
    public User getUserByfullName(String fullName) {
        Optional<User> findByfullName = userRepository.findOneByFullName(fullName);
        return findByfullName.orElseThrow(RuntimeException::new);
    }

    @Override
    public List<User> getUserByGender(String gender) {
        List<User> byGender = userRepository.findByGender(gender);
        return byGender;
    }

    @Override
    public List<User> getUserByTextSearch(String fullName) {
        return userRepository.findByfullNameTextSearch(fullName);
    }
}
