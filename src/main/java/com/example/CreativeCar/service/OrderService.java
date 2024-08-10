package com.example.CreativeCar.service;

import com.example.CreativeCar.entity.Order;
import com.example.CreativeCar.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findByUserId(Long id) {
        return orderRepository.findAllByUserIdAndStatus(id,"A");
    }

    
}
