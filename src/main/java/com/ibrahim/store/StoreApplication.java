package com.ibrahim.store;

import com.ibrahim.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		var user = User.builder()
				.name("Ibrahim")
				.email("ibrahim@gmail.com")
				.password("1234")
				.build();
	}

}
