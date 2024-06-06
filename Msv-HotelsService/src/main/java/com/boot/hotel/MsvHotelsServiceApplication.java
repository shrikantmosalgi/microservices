package com.boot.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvHotelsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvHotelsServiceApplication.class, args);
	}

}
