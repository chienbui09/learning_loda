package com.personal.configuration;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class MongoConfiguration {
    @Autowired
    MongoParams mongoParams;
    @Value("${spring.mongo.database-name}")
    private String databaseName;

    public MongoClientSettings getMongoClientSetting() {
        try {
            return MongoClientSettings.builder()
                    .applyToClusterSettings(
                            builder -> builder.hosts(
                                    Arrays.asList(new ServerAddress(
                                            mongoParams.getHost(), mongoParams.getPort()))
                            )
                    )
                    .credential(getMongoCredential())
                    .codecRegistry(getCodecRegistry())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public MongoCredential getMongoCredential() {
        return MongoCredential.createCredential(mongoParams.getUsername(),
                mongoParams.getAuthDb(),
                mongoParams.getPassword().toCharArray()
        );
    }

    public CodecRegistry getCodecRegistry() {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        return fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
    }

    @Bean
    public MongoDatabase getDataBase() {
        try {
            MongoClient mongoClient = MongoClients.create(getMongoClientSetting());
            return mongoClient.getDatabase(databaseName);
        } catch (MongoException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public <T> MongoCollection<T> getMongoCollection(String collectionName, Class<T> responseType) {
        return getDataBase().getCollection(collectionName, responseType);
    }

}
