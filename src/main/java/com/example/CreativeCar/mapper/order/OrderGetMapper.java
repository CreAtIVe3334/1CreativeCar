package com.example.CreativeCar.mapper.order;

import com.example.CreativeCar.dto.Order.GetOrderInformationDTO;
import com.example.CreativeCar.entity.Order;

import java.time.LocalDate;

public class OrderGetMapper {
    public static GetOrderInformationDTO entityToDto(Order order) {
        LocalDate startTime = order.getStartTime().toLocalDate();
        LocalDate endTime = order.getEndTime().toLocalDate();
        return GetOrderInformationDTO.builder()
                .startTime(startTime)
                .endTime(endTime)
                .orderAmount(order.getOrderAmount())
                .carName(order.getCar().getBrand()).build();
    }
}
