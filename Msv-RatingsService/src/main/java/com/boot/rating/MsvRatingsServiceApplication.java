package com.boot.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class MsvRatingsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvRatingsServiceApplication.class, args);
	}

}
