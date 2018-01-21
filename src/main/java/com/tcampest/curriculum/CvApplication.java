package com.tcampest.curriculum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcampest.curriculum.domain.User;
import com.tcampest.curriculum.repository.UserRepository;

@SpringBootApplication
public class CvApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CvApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		
		//List<GrantedAuthority> authorityUserAdmin = null;// = {"USER","ADMIN"};
		//List<GrantedAuthority> authorityUser = null;// = {"USER"};
		
		
		String[] authorityUserAdmin = {"ROLE_USER","ROLE_ADMIN"};
		String[] authorityUser = {"ROLE_USER"};
			
		// save a couple of customers
		repository.save(new User("Alice", "Smith", "asmith", "password", authorityUserAdmin));
		repository.save(new User("Bob", "Smith", "bsmith", "password", authorityUser));

		// fetch all customers
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("User found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));
		System.out.println(repository.findByUsername("asmith"));

		System.out.println("Users found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (User customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}
}
