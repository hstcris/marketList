package com.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.market.config")
@SpringBootApplication
public class MarketListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketListApplication.class, args);
	}
}
