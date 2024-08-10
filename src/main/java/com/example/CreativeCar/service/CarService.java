package com.example.CreativeCar.service;

import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car getCarById(Long id) {
        var car = carRepository.getById(id);
        return car;
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }



}
