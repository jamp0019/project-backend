package com.zeus.projectbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjectBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectBackendApplication.class, args);
	}

}
