package com.ibrahim.store.repositories;

import com.ibrahim.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
