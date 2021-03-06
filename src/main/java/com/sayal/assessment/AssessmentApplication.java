package com.sayal.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication
@ComponentScan("com.sayal.assessment")
@EnableJpaRepositories("com.sayal.assessment.persistance")
@EntityScan("com.sayal.assessment.persistance")
public class AssessmentApplication {

	public static void main(String[] args) {

		SpringApplication.run(AssessmentApplication.class, args);

	}
}
