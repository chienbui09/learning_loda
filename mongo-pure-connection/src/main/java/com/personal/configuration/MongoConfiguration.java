package com.personal.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MongoConfiguration {
    @Value("${mongo.uri}")
    private String connectionString;
    @Value("${mongo.database-name}")
    private String databaseName;

    @Bean
    public MongoClientSettings getMongoClientSetting(){
        try {
             return MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .build();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Bean
    public MongoDatabase getDataBase(){
        try(MongoClient mongoClient = MongoClients.create(getMongoClientSetting())){
            return mongoClient.getDatabase(databaseName);
        } catch (MongoException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public <T> MongoCollection<T> getMongoCollection(String collectionName,Class<T> responseType){
        return getDataBase().getCollection(collectionName,responseType);
    }

}
