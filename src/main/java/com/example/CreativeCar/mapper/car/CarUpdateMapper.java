package com.example.CreativeCar.mapper.car;

import com.example.CreativeCar.dto.car.CarUpdateRequestDto;
import com.example.CreativeCar.entity.Car;

public class CarUpdateMapper {

    public static CarUpdateRequestDto entityToDto(Car car) {
        return CarUpdateRequestDto.builder()
                .color(car.getColor())
                .price(car.getPrice())
                .gear(car.getGear())
                .engine(car.getEngine())
                .picture(car.getPicture())
                .build();
    }

    public static void dtoToEntity(CarUpdateRequestDto carUpdateRequest, Car car) {
        car.setColor(carUpdateRequest.getColor());
        car.setPrice(carUpdateRequest.getPrice());
        car.setGear(carUpdateRequest.getGear());
        car.setEngine(carUpdateRequest.getEngine());
        car.setPicture(carUpdateRequest.getPicture());
    }
}
