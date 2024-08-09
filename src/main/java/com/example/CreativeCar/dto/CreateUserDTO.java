package com.example.CreativeCar.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserDTO {
    String username;
    String name;
    String email;
    String phone;
    String licence;
}
