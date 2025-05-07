package com.ibrahim.store;

import com.ibrahim.store.entities.Address;
import com.ibrahim.store.entities.User;
import com.ibrahim.store.repositories.AddressRepository;
import com.ibrahim.store.repositories.ProfileRepository;
import com.ibrahim.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private  final EntityManager entityManager;
    private final AddressRepository addressRepository;

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

    @Transactional
    public void showUserProfile(){
        var profile = profileRepository.findById(1L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void showAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated(){
        var user = User.builder().name("ibrahim").email("ibrahim@gmail.com").password("123").build();
        var address = Address.builder().state("Dhaka").street("Dhaka").city("Dhaka").zip("1209").build();

        user.addAddress(address);
        userRepository.save(user);
    }

}
