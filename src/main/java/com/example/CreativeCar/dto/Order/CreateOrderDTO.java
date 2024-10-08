package com.example.CreativeCar.dto.Order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderDTO {

    LocalDate startTime;

    LocalDate endTime;

}
