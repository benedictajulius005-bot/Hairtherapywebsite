package com.hairtherapy.hairtherapy.repository;

import com.hairtherapy.hairtherapy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
