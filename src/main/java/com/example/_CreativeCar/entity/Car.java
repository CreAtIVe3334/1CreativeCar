package com.example._CreativeCar.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
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
