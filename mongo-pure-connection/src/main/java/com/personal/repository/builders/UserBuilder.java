package com.personal.repository.builders;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.TextSearchOptions;
import lombok.extern.log4j.Log4j2;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Component
public class UserBuilder {
    public Bson getFullNameEqBuilder(String fullName){
        return Filters.eq("fullName", fullName);
    }

    public Bson getFullNameSearchBuilder(String name, boolean caseSensitive){
        log.info("text: ['{}]",Filters.text(name, new TextSearchOptions().caseSensitive(caseSensitive)));
        return Filters.text(name);
    }
    public Bson getFullNameSearchBuilder(boolean caseSensitive, String... name){
        String textAndCondition= Arrays.stream(name)
                .filter(
                        StringUtils::hasText
                )
                .map(word -> String.join("", "\"", word, "\""))
                .collect(Collectors.joining(" "));
        return this.getFullNameSearchBuilder(textAndCondition,caseSensitive);
    }

    public Bson getGenderEqBuilder(Object gender){
        return Filters.eq("gender", gender);
    }
}
