package com.ibrahim.store;

import com.ibrahim.store.entities.Address;
import com.ibrahim.store.entities.Category;
import com.ibrahim.store.entities.Product;
import com.ibrahim.store.entities.User;
import com.ibrahim.store.repositories.AddressRepository;
import com.ibrahim.store.repositories.ProductRepository;
import com.ibrahim.store.repositories.ProfileRepository;
import com.ibrahim.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private  final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

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

    @Transactional
    public void deleteRelated(){
//        userRepository.deleteById(1L);

        var user = userRepository.findById(1L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddrees(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts(){
//        var category = new Category("fashion");
        var category = categoryRepository.findById((byte)1).orElseThrow();
        var product = Product.builder()
                .name("product 2")
                .price(BigDecimal.valueOf(10.99))
                .description("product description")
                .category(category)
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void updateProductPrices(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte) 1);
    }

    public void fetchProducts(){
        var products = productRepository.findByCategory(new Category((byte)1));
        products.forEach(System.out::println);
    }
}
