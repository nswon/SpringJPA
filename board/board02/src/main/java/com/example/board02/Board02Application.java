package com.example.board02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Board02Application {

	public static void main(String[] args) {
		SpringApplication.run(Board02Application.class, args);
	}

}
