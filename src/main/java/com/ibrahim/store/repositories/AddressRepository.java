package com.ibrahim.store.repositories;

import com.ibrahim.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}