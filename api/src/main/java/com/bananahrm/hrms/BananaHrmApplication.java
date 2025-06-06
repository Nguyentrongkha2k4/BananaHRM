package com.bananahrm.hrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BananaHrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BananaHrmApplication.class, args);
	}

}
