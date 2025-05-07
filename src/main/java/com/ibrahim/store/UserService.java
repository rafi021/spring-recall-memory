package com.ibrahim.store;

import com.ibrahim.store.entities.User;
import com.ibrahim.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private  final EntityManager entityManager;

    @Transactional
    public void showEntityStates(){
        var user = User.builder().name("ibrahim").email("abc@gmail.com").password("123").build();

        if(entityManager.contains(user))
            System.out.println("Persistenet");
        else
            System.out.println("Transient/Detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Persistenet");
        else
            System.out.println("Transient/Detached");

    }

}
