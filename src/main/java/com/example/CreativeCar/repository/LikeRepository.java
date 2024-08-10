package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Like;
import com.example.CreativeCar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    
    Optional<Like> findByCarAndUser(Car car, Users user);

    void delete(Optional<Like> like);
}
