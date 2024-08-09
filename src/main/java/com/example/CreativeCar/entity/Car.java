package com.example.CreativeCar.entity;

import com.example.CreativeCar.utility.core_entity.CoreEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car extends CoreEntity {
    String brand;
    String model;
    String color;
    String engine;
    String gear;
    Integer year;
    Double price;

    @OneToMany(mappedBy = "car")
    List<Order> orders;

}
