package com.example.CreativeCar.controller;

import com.example.CreativeCar.dto.car.CarUpdateRequestDto;
import com.example.CreativeCar.dto.car.CreateCarRequestDto;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/a")
    public Optional<List<Car>> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public Car createCar(@RequestBody CreateCarRequestDto createCarRequest) {
        return carService.createCar(createCarRequest);
    }

    @GetMapping("/{carId}")
    public Car getCarById(@PathVariable Long carId) {
        return carService.getCarById(carId);
    }

    @PutMapping("/{carId}")
    public Car updateCar(@PathVariable Long carId,
                         @RequestBody CarUpdateRequestDto carUpdateRequest) {
        return carService.updateCar(carId,carUpdateRequest);
    }

    @DeleteMapping("/{carId}")
    public void deleteCarById(@PathVariable Long carId) {
        carService.deleteCarById(carId);
    }

}

