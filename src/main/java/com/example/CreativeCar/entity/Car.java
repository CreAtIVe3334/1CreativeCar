package com.example.CreativeCar.entity;

import com.example.CreativeCar.enums.CarOrder;
import com.example.CreativeCar.utility.core_entity.CoreEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    String picture;
    @Enumerated(EnumType.STRING)
    CarOrder carOrder;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    List<Like> likes;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    List<Order> orders;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    List<Comment> comments;

}
