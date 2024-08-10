package com.example.CreativeCar.dto.Users;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUserDTO {
    String name;
    Double balance;
    String carName;

}
