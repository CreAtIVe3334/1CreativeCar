package com.example.CreativeCar.service;

import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Like;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    private final CarService carService;

    private final UserService userService;

    public Like save(Long userId,Long carId) {
        Users user = userService.getUserById(userId);
        Car car = carService.getCarById(carId);
        Like like = Like.builder()
                .user(user)
                .car(car)
                .build();
        return likeRepository.save(like);
    }

    public void delete(Long userId,Long carId) {
        Users user = userService.getUserById(userId);
        Car car = carService.getCarById(carId);
        Optional<Like> like = likeRepository.findByCarAndUser(car,user);
        if(like.isPresent()){
            Like like1 = like.get();
            likeRepository.delete(like1);
        }

    }
}
