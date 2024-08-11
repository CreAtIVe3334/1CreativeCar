package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
