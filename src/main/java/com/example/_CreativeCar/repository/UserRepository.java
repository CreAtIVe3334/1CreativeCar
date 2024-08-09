package com.example._CreativeCar.repository;

import com.example._CreativeCar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
