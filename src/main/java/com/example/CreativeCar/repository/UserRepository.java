package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsernameAndStatus(String username, String status);
    Optional<List<Users>> findAllByStatus(String status);
    Optional<Users> findByIdAndStatus(Long id, String status);
}
