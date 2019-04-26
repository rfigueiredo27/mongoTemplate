package com.rfigueiredo.mongoTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@SpringBootApplication
public class MongoTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTemplateApplication.class, args);
	}

}
