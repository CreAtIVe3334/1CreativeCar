package com.example._CreativeCar.repository;

import com.example._CreativeCar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
