package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
