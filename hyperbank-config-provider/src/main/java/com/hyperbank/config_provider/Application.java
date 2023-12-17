package com.hyperbank.config_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableConfigServer
@ComponentScan(basePackages = { "com.hyperbank*", "io.github.paulmarcelinbejan*" } )
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Configuration
	public static class SecurityPermitAllConfig {
		
		@Bean
		public SecurityFilterChain filterChain(final HttpSecurity httpSecurity) throws Exception {
			httpSecurity.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
			return httpSecurity.build();
		}
		
	}
	
}
