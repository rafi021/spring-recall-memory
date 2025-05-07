package com.ibrahim.store;

import com.ibrahim.store.entities.*;
import com.ibrahim.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		var service = context.getBean(UserService.class);
		service.updateProductPrices();
	}

}
