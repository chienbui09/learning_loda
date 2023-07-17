package com.personal.repository.builders;

import com.mongodb.client.model.Filters;
import lombok.extern.log4j.Log4j2;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Component
public class UserBuilder {
    public Bson getFullNameEqBuilder(String fullName){
        return Filters.eq("fullName", fullName);
    }

    public Bson getFullNameSearchBuilder(String name){
        log.info("text: ['{}]",Filters.text(name));
        return Filters.text(name);
    }
    public Bson getFullNameSearchBuilder(String... name){
        List<Bson> textNames = new ArrayList<>();
        Arrays.stream(name)
                .filter(
                        StringUtils::hasText
                )
                .map(this::getFullNameSearchBuilder)
                .iterator()
                .forEachRemaining(textNames::add);
        return Filters.and(textNames);
    }

    public Bson getGenderEqBuilder(Object gender){
        return Filters.eq("gender", gender);
    }
}
