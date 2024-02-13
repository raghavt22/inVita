package com.vita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.emart.*")
@EnableJpaRepositories(basePackages = "com.emart.repository")
@EntityScan(basePackages = "com.emart.entities")
public class EmartApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmartApplication.class, args);
	}

}
