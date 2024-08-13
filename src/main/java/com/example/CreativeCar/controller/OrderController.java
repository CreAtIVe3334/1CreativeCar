package com.example.CreativeCar.controller;

import com.example.CreativeCar.dto.Order.CreateOrderDTO;
import com.example.CreativeCar.dto.Order.GetOrderInformationDTO;
import com.example.CreativeCar.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    OrderService orderService;

    @PostMapping("/create/{userId}/{carId}")
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDTO createOrderDTO, @PathVariable Long userId, @PathVariable Long carId) {
        orderService.create(userId, carId, createOrderDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<GetOrderInformationDTO>> getOrderInformation(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.findByUserId(userId));
    }


}
