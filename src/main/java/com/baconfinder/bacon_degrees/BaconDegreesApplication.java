package com.baconfinder.bacon_degrees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BaconDegreesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaconDegreesApplication.class, args);
	}

}
