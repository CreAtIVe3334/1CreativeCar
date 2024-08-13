package com.example.CreativeCar.mapper.car;

import com.example.CreativeCar.dto.car.CreateCarRequestDto;
import com.example.CreativeCar.entity.Car;

public class CarCreateMapper    {
    public static Car dtoToEntity(CreateCarRequestDto createCarRequest) {
        return Car.builder()
                .brand(createCarRequest.getBrand())
                .model(createCarRequest.getModel())
                .gear(createCarRequest.getGear())
                .color(createCarRequest.getColor())
                .engine(createCarRequest.getEngine())
                .year(createCarRequest.getYear())
                .price(createCarRequest.getPrice())
                .picture(createCarRequest.getPicture())
                .build();
    }
}
