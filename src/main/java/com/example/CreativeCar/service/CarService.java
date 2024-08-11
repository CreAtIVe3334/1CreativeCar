package com.example.CreativeCar.service;

import com.example.CreativeCar.dto.car.CarUpdateRequestDto;
import com.example.CreativeCar.dto.car.CreateCarRequestDto;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAllCarByStatus("A");
    }


    public Car createCar(CreateCarRequestDto createCarRequest) {
        Car car = Car.builder()
                .brand(createCarRequest.getBrand())
                .model(createCarRequest.getModel())
                .gear(createCarRequest.getGear())
                .color(createCarRequest.getColor())
                .engine(createCarRequest.getEngine())
                .year(createCarRequest.getYear())
                .price(createCarRequest.getPrice())
                .picture(createCarRequest.getPicture())
                .status("A")
                .build();
        return carRepository.save(car);

    }

    public Car getCarById(Long id) {
       return carRepository.findByIdAndStatus(id,"A").orElse(null);

    }


    public Car updateCar(Long carId, CarUpdateRequestDto carUpdateRequest) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.isPresent()) {
            Car updatedCar =car.get();
            updatedCar.setColor(carUpdateRequest.getColor());
            updatedCar.setEngine(carUpdateRequest.getEngine());
            updatedCar.setGear(carUpdateRequest.getGear());
            updatedCar.setPrice(carUpdateRequest.getPrice());
            updatedCar.setPicture(carUpdateRequest.getPicture());
            return carRepository.save(updatedCar);
        }
        return null;
    }

    public void deleteCarById(Long carId) {
       Car car = carRepository.findByIdAndStatus(carId,"A").orElse(null);
        car.setStatus("D");
        carRepository.save(car);
    }

}