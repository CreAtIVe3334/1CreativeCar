package com.example.CreativeCar.dto.Users;

import com.example.CreativeCar.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserDTO {
    String username;
    String name;
    String email;
    String phone;
    String licence;
    Double balance;
}
