package com.cognizant.aws.fse.profileprocessor.configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.jms.Connection;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.util.StringUtils;

import net.spy.memcached.MemcachedClient;

@Configuration
//@EnableDynamoDBRepositories
  //(basePackages = "com.cognizant.aws.fse.userservice.dao")
public class UserMicroServiceAppConfiguration {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;
    
    @Value("${spring.activemq.host}")
    private String WIRE_LEVEL_ENDPOINT;
    
    @Value("${spring.activemq.port}")
    private String WIRE_LEVEL_ENDPOINT_PORT;
    
    @Value("${spring.activemq.username}")
    private String ACTIVE_MQ_USERNAME;
    
    @Value("${spring.activemq.password}")
    private String ACTIVE_MQ_PASSWORD;
    
    @Value("${spring.memchae.endpoint}")
    private String MEMCACHE_END_POINT;

    @Value("${spring.memchae.port}")
    private int MEMCACHE_PORT;
   @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        //AmazonDynamoDB amazonDynamoDB 
          //= new AmazonDynamoDBClient(amazonAWSCredentials()).withRegion(Regions.US_EAST_2);
        AmazonDynamoDB amazonDynamoDB  = AmazonDynamoDBClientBuilder.standard().build();
        if (!StringUtils.isNullOrEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
        
        return amazonDynamoDB;
    }
   
   @Bean
   public DynamoDBMapper dynamoDBmapper() {
	   DynamoDBMapper dynamoDBmapper = new DynamoDBMapper(amazonDynamoDB());
	   return dynamoDBmapper;
   }
   
   @Bean
   public Index index () {
	   DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB());
		Table table = dynamoDB.getTable("FSEProfile");
		Index index = table.getIndex("GSI-search-index4");

	   return index;
   }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
          amazonAWSAccessKey, amazonAWSSecretKey);
    }
    
 }
