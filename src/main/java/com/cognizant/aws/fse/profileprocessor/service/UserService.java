package com.cognizant.aws.fse.profileprocessor.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.cognizant.aws.fse.profileprocessor.Json.domain.UserJsonModel;
import com.cognizant.aws.fse.profileprocessor.model.User;
import com.cognizant.aws.fse.profileprocessor.util.UserModelJsonConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	
	
	@Autowired
	AmazonDynamoDB amzonDynamoDB;
	
	@Autowired
	Index index;

	
	public void saveUser(UserJsonModel userModel)  {
		User user = UserModelJsonConverter.convertUserJsonModel(userModel);
		DynamoDBMapper dynamoDBmapper = new DynamoDBMapper(amzonDynamoDB);
		dynamoDBmapper.save(user);
	}
	
	public void updateUser(User user)  {
		DynamoDBMapper dynamoDBmapper = new DynamoDBMapper(amzonDynamoDB);
		DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
				  .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
				  .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE)
				  .build();
		dynamoDBmapper.save(user,dynamoDBMapperConfig);
	}

	public User getUserByUserId(String userId) {
		//List<User> users = userDao.findByUserId(userId);
		ValueMap valueMap = new ValueMap();
		String keyExpression = "UserId = :v1";
		valueMap.withString(":v1", userId);
		QuerySpec spec = new QuerySpec()
				.withKeyConditionExpression(keyExpression)
				.withValueMap(valueMap);
		ItemCollection<QueryOutcome> items = index.query(spec);
		Iterator<Item> iterator = items.iterator();
		User user = null;
		while (iterator.hasNext()) {
			String json = iterator.next().toJSON();
			System.out.println(json);
			ObjectMapper obj = new ObjectMapper();
			try {
				user = obj.readValue(json, User.class);
				System.out.println(user.getAssociateName());
				System.out.println(user.getAssociateId());
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
}
