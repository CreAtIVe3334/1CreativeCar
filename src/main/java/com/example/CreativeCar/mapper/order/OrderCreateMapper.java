package com.example.CreativeCar.mapper.order;

import com.example.CreativeCar.dto.Order.CreateOrderDTO;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Order;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.utility.QDate;

import java.time.LocalDateTime;
import java.util.Optional;


public class OrderCreateMapper {
    public static Order dtoToEntity(CreateOrderDTO createOrderDTO, Optional<Car> car, Optional<Users> users){
        LocalDateTime startTime = QDate.startDateToLocalDateTime(createOrderDTO.getStartTime());
        LocalDateTime endTime = QDate.endDateToLocalDateTime(createOrderDTO.getEndTime());
        return Order.builder()
                .car(car.get())
                .user(users.get())
                .startTime(startTime)
                .endTime(endTime)
                .orderAmount(createOrderDTO.getOrderAmount()).build();
    }
}
