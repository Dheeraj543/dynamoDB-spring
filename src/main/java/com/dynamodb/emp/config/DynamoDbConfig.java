package com.dynamodb.emp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDbConfig {
	@Value("${aws.server-endpoint}")
	String endpoint;
	@Value("${aws.location}")
	String location;
	@Value("${aws.accesskey}")
	String accesskey;
	@Value("${aws.credentialskey}")
	String credentialskey;
	   
	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());
	}
	@Bean
	public AmazonDynamoDB amazonDynamoDBConfig() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, location))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accesskey,credentialskey))).build();
	}
}	
