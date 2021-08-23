package com.hadiyan.btsshoppingapp.repository;

import com.hadiyan.btsshoppingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail (String email);
}
