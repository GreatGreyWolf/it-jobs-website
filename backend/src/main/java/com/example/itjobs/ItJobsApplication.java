package com.example.itjobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.itjobs")
@EntityScan("com.example.itjobs.entity")
@EnableJpaRepositories("com.example.itjobs.repository")
public class ItJobsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItJobsApplication.class, args);
	}

}
