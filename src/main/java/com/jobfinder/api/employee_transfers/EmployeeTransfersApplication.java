package com.jobfinder.api.employee_transfers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@ConfigurationPropertiesScan("com.jobfinder.api.employee_transfers")
public class EmployeeTransfersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeTransfersApplication.class, args);
	}

}
