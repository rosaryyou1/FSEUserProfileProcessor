package com.cognizant.aws.fse.profileprocessor.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "FSEProfile")
public class User {
	String userId;
	String mobile;
	String email;
	String angular;
	int angularLevel;
	String htmlCss;
	int htmlCssLevel;
	String react;
	int reactLevel;
	String spring;
	int springLevel;
	String rest;
	int restLevel;
	String hibernate;
	int hibernateLevel;
	String git;
	int gitLevel;
	String docker;
	int dockerLevel;
	String jenkins;
	int jenkinsLevel;
	String aws;
	int awsLevel;
	String spoken;
	int spokenLevel;
	String communication;
	int communicationLevel;
	String aptitude;
	int aptitudeLevel;
	String cre8Ts;
	String lstUptTs;
	String associateName;
	String associateId;

	@DynamoDBHashKey(attributeName ="AssociateId")	
	public String getAssociateId() {
		return associateId;
	}
	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	
	@DynamoDBRangeKey(attributeName ="AssociateName")
	//@DynamoDBAttribute(attributeName="AssociateName")
	public String getAssociateName() {
		return associateName;
	}
	public void setAssociateName(String assoicateName) {
		this.associateName = assoicateName;
	}
	//@Id
	//UserUniqueId userUniqueId;	
	
/*	public UserUniqueId getUserUniqueId() {
		return userUniqueId;
	}

	public void setUserUniqueId(UserUniqueId userUniqueId) {
		this.userUniqueId = userUniqueId;
	}*/

	public User() {

	}
	/*public User(String 
			String argName,String argAssociateId,String argMobile,String argEmail) {
		this.name = argName;
		this.associateId=argAssociateId;
		this.email=argEmail;
		this.mobile=argMobile;
	}*/



	
	
	
	@DynamoDBAttribute(attributeName="Mobile")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@DynamoDBAttribute(attributeName = "Email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName = "GSI-search-index4",attributeName = "UserId")
	//@DynamoDBHashKey(attributeName ="UserId")
	@DynamoDBAutoGeneratedKey
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@DynamoDBIndexHashKey(globalSecondaryIndexName = "GSI-search-index1",attributeName = "Angular")
	public String getAngular() {
		return angular;
	}

	public void setAngular(String angular) {
		this.angular = angular;
	}

	@DynamoDBAttribute(attributeName="AngularLevel")
	public int getAngularLevel() {
		return angularLevel;
	}

	public void setAngularLevel(int angularLevel) {
		this.angularLevel = angularLevel;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName = "GSI-search-index2",attributeName = "HtmlCss")
	public String getHtmlCss() {
		return htmlCss;
	}

	public void setHtmlCss(String htmlCss) {
		this.htmlCss = htmlCss;
	}

	@DynamoDBAttribute(attributeName="HtmlCssLevel")
	public int getHtmlCssLevel() {
		return htmlCssLevel;
	}

	public void setHtmlCssLevel(int htmlCssLevel) {
		this.htmlCssLevel = htmlCssLevel;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName = "GSI-search-index3",attributeName = "React")
	public String getReact() {
		return react;
	}

	public void setReact(String react) {
		this.react = react;
	}

	@DynamoDBAttribute(attributeName="ReactLevel")
	public int getReactLevel() {
		return reactLevel;
	}

	public void setReactLevel(int reactLevel) {
		this.reactLevel = reactLevel;
	}

	@DynamoDBAttribute(attributeName="Spring")
	public String getSpring() {
		return spring;
	}

	public void setSpring(String spring) {
		this.spring = spring;
	}

	@DynamoDBAttribute(attributeName="SpringLevel")
	public int getSpringLevel() {
		return springLevel;
	}

	public void setSpringLevel(int springLevel) {
		this.springLevel = springLevel;
	}
	
	@DynamoDBAttribute(attributeName="Rest")
	public String getRest() {
		return rest;
	}

	public void setRest(String rest) {
		this.rest = rest;
	}

	@DynamoDBAttribute(attributeName="RestLevel")
	public int getRestLevel() {
		return restLevel;
	}

	public void setRestLevel(int restLevel) {
		this.restLevel = restLevel;
	}

	@DynamoDBAttribute(attributeName="Hibernate")
	public String getHibernate() {
		return hibernate;
	}

	public void setHibernate(String hibernate) {
		this.hibernate = hibernate;
	}

	@DynamoDBAttribute(attributeName="HibernateLevel")
	public int getHibernateLevel() {
		return hibernateLevel;
	}

	public void setHibernateLevel(int hibernateLevel) {
		this.hibernateLevel = hibernateLevel;
	}

	@DynamoDBAttribute(attributeName="Git")
	public String getGit() {
		return git;
	}

	public void setGit(String git) {
		this.git = git;
	}

	@DynamoDBAttribute(attributeName="GitLevel")
	public int getGitLevel() {
		return gitLevel;
	}

	public void setGitLevel(int gitLevel) {
		this.gitLevel = gitLevel;
	}

	@DynamoDBAttribute(attributeName="Docker")
	public String getDocker() {
		return docker;
	}

	public void setDocker(String docker) {
		this.docker = docker;
	}

	@DynamoDBAttribute(attributeName="DockerLevel")
	public int getDockerLevel() {
		return dockerLevel;
	}

	public void setDockerLevel(int dockerLevel) {
		this.dockerLevel = dockerLevel;
	}
	@DynamoDBAttribute(attributeName="Jenkins")
	public String getJenkins() {
		return jenkins;
	}

	public void setJenkins(String jenkins) {
		this.jenkins = jenkins;
	}
	@DynamoDBAttribute(attributeName="JenkinsLevel")
	public int getJenkinsLevel() {
		return jenkinsLevel;
	}

	public void setJenkinsLevel(int jenkinsLevel) {
		this.jenkinsLevel = jenkinsLevel;
	}

	@DynamoDBAttribute(attributeName="Aws")
	public String getAws() {
		return aws;
	}

	public void setAws(String aws) {
		this.aws = aws;
	}
	@DynamoDBAttribute(attributeName="AwsLevel")
	public int getAwsLevel() {
		return awsLevel;
	}

	public void setAwsLevel(int awsLevel) {
		this.awsLevel = awsLevel;
	}

	@DynamoDBAttribute(attributeName="Spoken")
	public String getSpoken() {
		return spoken;
	}

	public void setSpoken(String spoken) {
		this.spoken = spoken;
	}
	@DynamoDBAttribute(attributeName="SpokenLevel")
	public int getSpokenLevel() {
		return spokenLevel;
	}

	public void setSpokenLevel(int spokenLevel) {
		this.spokenLevel = spokenLevel;
	}

	@DynamoDBAttribute(attributeName="Communication")
	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	@DynamoDBAttribute(attributeName="CommunicationLevel")
	public int getCommunicationLevel() {
		return communicationLevel;
	}

	public void setCommunicationLevel(int communicationLevel) {
		this.communicationLevel = communicationLevel;
	}

	@DynamoDBAttribute(attributeName="Aptitude")
	public String getAptitude() {
		return aptitude;
	}

	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}

	@DynamoDBAttribute(attributeName="AptitudeLevel")
	public int getAptitudeLevel() {
		return aptitudeLevel;
	}

	public void setAptitudeLevel(int aptitudeLevel) {
		this.aptitudeLevel = aptitudeLevel;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ",  mobile=" + mobile + ", email=" + email + ", angular=" + angular + ", angularLevel=" + angularLevel
				+ ", htmlCss=" + htmlCss + ", htmlCssLevel=" + htmlCssLevel + ", react=" + react + ", reactLevel="
				+ reactLevel + ", spring=" + spring + ", springLevel=" + springLevel + ", rest=" + rest + ", restLevel="
				+ restLevel + ", hibernate=" + hibernate + ", hibernateLevel=" + hibernateLevel + ", git=" + git
				+ ", gitLevel=" + gitLevel + ", docker=" + docker + ", dockerLevel=" + dockerLevel + ", jenkins="
				+ jenkins + ", jenkinsLevel=" + jenkinsLevel + ", aws=" + aws + ", awsLevel=" + awsLevel + ", spoken="
				+ spoken + ", spokenLevel=" + spokenLevel + ", communication=" + communication + ", communicationLevel="
				+ communicationLevel + ", aptitude=" + aptitude + ", aptitudeLevel=" + aptitudeLevel + "]";
	}
	@DynamoDBAttribute(attributeName = "Cre8Ts")
	public String getCre8Ts() {
		return cre8Ts;
	}
	public void setCre8Ts(String cre8Ts) {
		this.cre8Ts = cre8Ts;
	}
	
	@DynamoDBAttribute(attributeName = "LstUptTs")
	public String getLstUptTs() {
		return lstUptTs;
	}
	public void setLstUptTs(String lstUptTs) {
		this.lstUptTs = lstUptTs;
	}


	

}