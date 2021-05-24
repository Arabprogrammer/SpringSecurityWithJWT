package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import com.app.model.Role;
import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@SpringBootApplication
@ComponentScan("com.app")
public class SpringSecurityWithJwtApplication {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJwtApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void addFirtUser() {
		String email = "Arabprogrammer@gmail.com";
		User user = userService.findByUsername(email);
		if (user != null) {
			return;
		} else {
			User added = new User("Arabprogrammer", "Arabprogrammer@gmail.com", "12345678", Role.ADMIN);
			userService.saveUser(added);
		}
	}

}
