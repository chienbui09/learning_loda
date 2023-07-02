package com.personal.repository.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.personal.entity.User;
import com.personal.repository.IUserRepository;
import com.personal.repository.builders.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    MongoDatabase mongoDatabase;
    @Autowired
    UserBuilder userBuilder;

    private MongoCollection<User> getUserCollection(){
        return mongoDatabase.getCollection("user", User.class);
    }
    @Override
    public Optional<User> findOneByFullName(String fullName) {
        User user = getUserCollection().find(
                userBuilder.getFullNameEqBuilder(fullName)
        ).first();
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findByFullName(String fullName) {
        List<User> users = new ArrayList<>();
        getUserCollection().find(
                userBuilder.getFullNameEqBuilder(fullName)
        )
                .into(users);
        return users;
    }

    @Override
    public List<User> findByfullNameTextSearch(String fullName) {
        List<User> users = new ArrayList<>();
        getUserCollection().find(
                userBuilder.getFullNameSearchBuilder(fullName.split(" "))
        ).into(users);
        return users;
    }

    @Override
    public List<User> findByGender(String gender) {
        List<User> usersByGender = new ArrayList<>();
        getUserCollection().find(
                        userBuilder.getFullNameEqBuilder(gender)
                )
                .into(usersByGender);
        return usersByGender;
    }
}
