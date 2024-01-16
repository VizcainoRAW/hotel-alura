package com.vizcainoraw.hotelalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HotelAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelAluraApplication.class, args);
	}

}
