package com.hyperbank.types;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hyperbank.architecture.base.AbstractHyperBankApplication;

@SpringBootApplication
@ComponentScan({ "com.hyperbank*", "io.github.paulmarcelinbejan*" })
@EntityScan("com.hyperbank*")
@EnableJpaRepositories("com.hyperbank*")
public class HyperBankTypesApplication extends AbstractHyperBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyperBankTypesApplication.class, args);
	}

}
