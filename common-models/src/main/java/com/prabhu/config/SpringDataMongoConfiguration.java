package com.prabhu.config;

import com.mongodb.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.util.Collections;
import java.util.List;

/**
 * Created by prabhu on 1/10/16.
 */
@Configuration
@ComponentScan("com.prabhu.models")
public class SpringDataMongoConfiguration extends AbstractMongoConfiguration {

    public static final int MONGO_CONNECTION_TIMEOUT = 30000;
    public static final String MONGO_DATABASE_NAME = "models";
    public static final String MONGO_USERNAME = "";
    public static final String MONGO_PASSWORD = "";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;

    @Override
    protected String getDatabaseName() {
        return MONGO_DATABASE_NAME;
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoClientOptions options = MongoClientOptions.builder()
                .connectTimeout(MONGO_CONNECTION_TIMEOUT)
                .build();
        ServerAddress serverAddress = new ServerAddress(MONGO_HOST,
                MONGO_PORT);
        List<ServerAddress> serverAddressList = Collections.singletonList(serverAddress);
        return new MongoClient(serverAddressList,
                getMongoCredential(getDatabaseName()),
                options);
    }

    private List<MongoCredential> getMongoCredential(String dbName){
        MongoCredential credential = MongoCredential.createCredential(MONGO_USERNAME,
                dbName,MONGO_PASSWORD.toCharArray());
        return Collections.singletonList(credential);
    }
}
