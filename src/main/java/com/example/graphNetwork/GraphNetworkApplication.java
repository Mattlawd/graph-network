package com.example.graphNetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GraphNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphNetworkApplication.class, args);
	}

}
