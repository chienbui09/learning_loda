package com.personal.repository.builders;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserBuilder {
    public Bson getFullNameEqBuilder(String fullName){
        return Filters.eq("fullName", fullName);
    }

    public Bson getFullNameSearchBuilder(String name){
        return Filters.text(name);
    }
    public Bson getFullNameSearchBuilder(String... name){
        List<Bson> textNames = new ArrayList<>();
        Arrays.asList(name).stream()
                .filter(
                        text -> !(StringUtils.isEmpty(text))
                )
                .map(this::getFullNameSearchBuilder)
                .iterator()
                .forEachRemaining(textNames::add);
        return Filters.and(textNames);
    }

    public Bson getGenderEqBuilder(String fullName){
        return Filters.eq("gender", fullName);
    }
}
