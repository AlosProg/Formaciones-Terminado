package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.curso.controller","com.curso.service"})
public class Ej02ClienteCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ej02ClienteCursoApplication.class, args);
	}

	@Bean
	   public RestTemplate getTemplate(){
	        return new RestTemplate();
	}
}
