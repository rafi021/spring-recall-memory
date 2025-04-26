package com.ibrahim.store;

import org.springframework.stereotype.Service;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
