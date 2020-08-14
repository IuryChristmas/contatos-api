package com.agenda.contatos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.agenda.contatos.api.cors.config.ContatosApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ContatosApiProperty.class)
public class ContatosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContatosApiApplication.class, args);
	}

}
