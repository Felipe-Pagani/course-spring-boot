package com.treinamento.coursespringbot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.treinamento.coursespringbot.entities.Order;
import com.treinamento.coursespringbot.entities.User;
import com.treinamento.coursespringbot.repositories.OrderRepository;
import com.treinamento.coursespringbot.repositories.UserRepository;

@Configuration
@Profile("test")
//Classe serve para fazer o database seeding
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Luiz souza", "LuizSouza@gmail.com", "2331-58396", "12345");
		User u2 = new User(null, "Matheus Lima", "MathLima@gmail.com", "2231-58354", "18584");

		// Formato UTC
		Order o1 = new Order(null, Instant.parse("2020-05-20T19:30:00Z"), u1);
		Order o2 = new Order(null, Instant.parse("2020-02-12T10:50:20Z"), u2);
		Order o3 = new Order(null, Instant.parse("2020-12-09T01:12:15Z"), u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
