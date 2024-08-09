package com.example._CreativeCar.repository;

import com.example._CreativeCar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
