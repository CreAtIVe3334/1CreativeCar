package com.example.CreativeCar.service;

import com.example.CreativeCar.dto.car.CarUpdateRequestDto;
import com.example.CreativeCar.dto.car.CreateCarRequestDto;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.enums.CarOrder;
import com.example.CreativeCar.mapper.car.CarCreateMapper;
import com.example.CreativeCar.mapper.car.CarUpdateMapper;
import com.example.CreativeCar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Optional<List<Car>> getAllCars() {
        return carRepository.findAllUnordered();
    }


    public Car createCar(CreateCarRequestDto createCarRequest) {
        Car car = CarCreateMapper.dtoToEntity(createCarRequest);
        return carRepository.save(car);

    }

    public Car getCarById(Long id) {
        return carRepository.findByIdAndStatus(id,"A").orElse(null);

    }

    public void updateCarOrder(Long carId,CarOrder carOrder) {
        Optional<Car> car = carRepository.findByIdAndStatus(carId,"A");
        if (car.isPresent()) {
            car.get().setCarOrder(carOrder);
            carRepository.save(car.get());
        }
    }


    public Car updateCar(Long carId, CarUpdateRequestDto carUpdateRequest) {
        Optional<Car> carOptional = carRepository.findByIdAndStatus(carId, "A");

        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            CarUpdateMapper.dtoToEntity(carUpdateRequest, car);

            return carRepository.save(car);
        }

        return null;
    }

    public void deleteCarById(Long carId) {
        Car car = carRepository.findByIdAndStatus(carId,"A").orElse(null);
        car.setStatus("D");
        carRepository.save(car);
    }

}
