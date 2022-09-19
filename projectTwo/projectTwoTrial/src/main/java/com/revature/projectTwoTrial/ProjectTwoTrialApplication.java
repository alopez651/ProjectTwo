package com.revature.projectTwoTrial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication

@PropertySource("dev.properties")
public class ProjectTwoTrialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTwoTrialApplication.class, args);
	}

}
