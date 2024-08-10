package com.example.CreativeCar.controller;

import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return ResponseEntity.ok(carService.createCar(car));
    }
}
