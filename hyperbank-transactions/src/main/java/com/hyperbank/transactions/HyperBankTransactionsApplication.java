package com.hyperbank.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.hyperbank*", "io.github.paulmarcelinbejan*" })
@EntityScan("com.hyperbank*")
@EnableJpaRepositories("com.hyperbank*")
public class HyperBankTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyperBankTransactionsApplication.class, args);
	}

}
