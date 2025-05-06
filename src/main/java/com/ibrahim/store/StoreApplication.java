package com.ibrahim.store;

import com.ibrahim.store.entities.Address;
import com.ibrahim.store.entities.Profile;
import com.ibrahim.store.entities.Tag;
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
		var profile = Profile.builder().bio("bio").dateOfBirth("2025-05-06").loyaltyPoints(1).phoneNumber("01675306077").build();
		user.addProfile(profile);
		System.out.println(user);
	}

}
