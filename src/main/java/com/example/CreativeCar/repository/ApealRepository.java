package com.example.CreativeCar.repository;

import com.example.CreativeCar.entity.Apeal;
import com.example.CreativeCar.enums.ApealProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApealRepository extends JpaRepository<Apeal, Long> {
    Iterable<Object> findByApealProgress(ApealProgress apealProgress);
}
