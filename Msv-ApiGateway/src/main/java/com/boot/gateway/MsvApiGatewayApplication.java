package com.boot.gateway;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsvApiGatewayApplication {
	//if you want learn about api gate way then go to spring cloud gate way and in learn you can read documentation
	
	public static void main(String[] args) {
		SpringApplication.run(MsvApiGatewayApplication.class, args);
	}

}
