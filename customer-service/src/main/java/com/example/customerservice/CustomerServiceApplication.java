package com.example.customerservice;

import com.example.customerservice.config.GlobalConfig;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	// chaque méthode qui utilise la notation @Bean avec spring c'a veut dir que c'a va
	// s'executer au demarrage

	// @builer fournit une méthode plus pratique que constructeur pour créer et configurer
	// les objets
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customerList = List.of(Customer.builder()
							.firstName("Mouad")
							.lastName("EL OMARI")
							.email("mouad.elomari@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Mohamed")
							.lastName("EL OMARI")
							.email("mohamed.elomari@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}
}