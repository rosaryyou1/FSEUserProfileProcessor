package com.cognizant.aws.fse.profileprocessor.util;

import java.util.List;

import com.cognizant.aws.fse.profileprocessor.Json.domain.Skill;
import com.cognizant.aws.fse.profileprocessor.Json.domain.UserJsonModel;
import com.cognizant.aws.fse.profileprocessor.model.User;

public class UserModelJsonConverter {
	public static User convertUserJsonModel(UserJsonModel userJson) {
		User user = new User();
		user.setAssociateId(userJson.getAssociateId());
		user.setAssociateName(userJson.getAssociateName());
		user.setEmail(userJson.getEmail());
		user.setMobile(userJson.getMobile());
		List<Skill> lstSkill = userJson.getSkills();
		for(Skill skill : lstSkill) {
		if("Angular".equalsIgnoreCase(skill.getSkillName())){
			user.setAngular(skill.getSkillName());
			user.setAngularLevel(skill.getSkillLevel());
			continue;
		}
		if("Aptitude".equalsIgnoreCase(skill.getSkillName())){
			user.setAptitude(skill.getSkillName());
			user.setAptitudeLevel(skill.getSkillLevel());
			continue;
		}
		if("AWS".equalsIgnoreCase(skill.getSkillName())){
			user.setAws(skill.getSkillName());
			user.setAwsLevel(skill.getSkillLevel());
			continue;
		}
		if("Communication".equalsIgnoreCase(skill.getSkillName())){
			user.setCommunication(skill.getSkillName());
			user.setCommunicationLevel(skill.getSkillLevel());
			continue;
		}
		if("Docker".equalsIgnoreCase(skill.getSkillName())){
			user.setDocker(skill.getSkillName());
			user.setDockerLevel(skill.getSkillLevel());
			continue;
		}

		if("Git".equalsIgnoreCase(skill.getSkillName())){
			user.setGit(skill.getSkillName());
			user.setGitLevel(skill.getSkillLevel());
			continue;
		}
		if("Hibernate".equalsIgnoreCase(skill.getSkillName())){
			user.setHibernate(skill.getSkillName());
			user.setHibernateLevel(skill.getSkillLevel());
			continue;
		}
		if("HtmlCss".equalsIgnoreCase(skill.getSkillName())){
			user.setHtmlCss(skill.getSkillName());
			user.setHtmlCssLevel(skill.getSkillLevel());
			continue;
		}
		if("Jenkins".equalsIgnoreCase(skill.getSkillName())){
			user.setJenkins(skill.getSkillName());
			user.setJenkinsLevel(skill.getSkillLevel());
			continue;
		}
		if("React".equalsIgnoreCase(skill.getSkillName())){
			user.setReact(skill.getSkillName());
			user.setReactLevel(skill.getSkillLevel());
			continue;
		}
	
		if("Rest".equalsIgnoreCase(skill.getSkillName())){
			user.setRest(skill.getSkillName());
			user.setRestLevel(skill.getSkillLevel());
			continue;
		}
		if("Spoken".equalsIgnoreCase(skill.getSkillName())){
			user.setSpoken(skill.getSkillName());
			user.setSpokenLevel(skill.getSkillLevel());
			continue;
		}
		if("Spring".equalsIgnoreCase(skill.getSkillName())){
			user.setSpring(skill.getSkillName());
			user.setSpringLevel(skill.getSkillLevel());
			continue;
		}
		}
		return user;
	}
}
