package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserIdAndStatus(Long ida, String status);
}
