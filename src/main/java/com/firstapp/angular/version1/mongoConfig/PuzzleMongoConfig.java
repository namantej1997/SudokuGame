package com.firstapp.angular.version1.mongoConfig;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@Configuration
@ConfigurationProperties(prefix = "mongodb.puzzle")
@EnableMongoRepositories(basePackages = "com.firstapp.angular.version1.mongoRepository.sudokuPuzzle", mongoTemplateRef = "puzzleMongoTemplate")
class PuzzleMongoConfig {

    private String host;
    private int port;
    private String database;

    @Primary
    @Bean(name = "puzzleMongoTemplate")
    public MongoTemplate puzzleMongoTemplate() throws Exception {
        final MongoClient mongoClient = createMongoClient(new ServerAddress("localhost", 27017));
        return new MongoTemplate(mongoClient, "sudokuPuzzle");
    }

    private MongoClient createMongoClient(ServerAddress serverAddress) {
        MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(serverAddress)))
                        .build());

        return mongoClient;
    }
}
