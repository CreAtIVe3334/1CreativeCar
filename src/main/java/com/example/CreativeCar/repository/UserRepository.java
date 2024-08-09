package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
