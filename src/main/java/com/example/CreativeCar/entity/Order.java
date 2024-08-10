package com.example.CreativeCar.entity;

import com.example.CreativeCar.utility.core_entity.CoreEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rental_order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends CoreEntity {

    LocalDateTime startTime;

    LocalDateTime endTime;

    Double orderAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    Car car;

}
