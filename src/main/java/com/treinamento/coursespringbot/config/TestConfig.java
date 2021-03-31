package com.treinamento.coursespringbot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.treinamento.coursespringbot.entities.Category;
import com.treinamento.coursespringbot.entities.Order;
import com.treinamento.coursespringbot.entities.OrderItem;
import com.treinamento.coursespringbot.entities.Payment;
import com.treinamento.coursespringbot.entities.Product;
import com.treinamento.coursespringbot.entities.User;
import com.treinamento.coursespringbot.entities.enums.OrderStatus;
import com.treinamento.coursespringbot.repositories.CategoryRepository;
import com.treinamento.coursespringbot.repositories.OrderItemRepository;
import com.treinamento.coursespringbot.repositories.OrderRepository;
import com.treinamento.coursespringbot.repositories.ProductRepository;
import com.treinamento.coursespringbot.repositories.UserRepository;

@Configuration
@Profile("test")
//Classe serve para fazer o database seeding
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Luiz souza", "LuizSouza@gmail.com", "2331-58396", "12345");
		User u2 = new User(null, "Matheus Lima", "MathLima@gmail.com", "2231-58354", "18584");
		
		Category c1 = new Category(null, "Electronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		// Formato UTC
		Order o1 = new Order(null, Instant.parse("2020-05-20T19:30:00Z"),
				OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2020-02-12T10:50:20Z"),
				OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2020-12-09T01:12:15Z"), 
				OrderStatus.SHIPPED, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2020-11-20T12:20:00Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
	}

}
