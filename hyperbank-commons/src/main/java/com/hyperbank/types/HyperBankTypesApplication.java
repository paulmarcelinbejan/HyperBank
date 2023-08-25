package com.hyperbank.types;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.hyperbank*", "com.paulmarcelinbejan*" })
@EntityScan("com.hyperbank*")
@EnableJpaRepositories("com.hyperbank*")
public class HyperBankTypesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyperBankTypesApplication.class, args);
	}

}