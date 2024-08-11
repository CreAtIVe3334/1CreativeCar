package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByIdAndStatus(Long id, String status);

    List<Car> findAllCarByStatus(String status);
}
