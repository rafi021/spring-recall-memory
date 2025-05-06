package com.ibrahim.store;

import com.ibrahim.store.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		var category = Category.builder().name("Fashion").build();
		var product = Product.builder().name("Men Wallet").price(12.3).build();
		category.addProduct(product);
		System.out.println(category);
	}

}
