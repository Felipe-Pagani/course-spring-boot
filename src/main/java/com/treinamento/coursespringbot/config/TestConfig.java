package com.treinamento.coursespringbot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.treinamento.coursespringbot.entities.User;
import com.treinamento.coursespringbot.repositories.UserRepository;

@Configuration
@Profile("test")
//Classe serve para fazer o database seeding
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Luiz souza", "LuizSouza@gmail.com", "2331-58396", "12345");
		User u2 = new User(null, "Matheus Lima", "MathLima@gmail.com", "2231-58354", "18584");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
	
}
