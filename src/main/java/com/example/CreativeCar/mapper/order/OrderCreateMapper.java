package com.example.CreativeCar.mapper.order;

import com.example.CreativeCar.dto.Order.CreateOderDTO;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Order;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.utility.QDate;

import java.time.LocalDateTime;
import java.util.Optional;


public class OrderCreateMapper {
    public static Order dtoToEntity(CreateOderDTO createOderDTO, Optional<Car> car, Optional<Users> users){
        LocalDateTime startTime = QDate.startDateToLocalDateTime(createOderDTO.getStartTime());
        LocalDateTime endTime = QDate.endDateToLocalDateTime(createOderDTO.getEndTime());
        return Order.builder()
                .car(car.get())
                .user(users.get())
                .startTime(startTime)
                .endTime(endTime)
                .orderAmount(createOderDTO.getOrderAmount()).build();
    }
}
