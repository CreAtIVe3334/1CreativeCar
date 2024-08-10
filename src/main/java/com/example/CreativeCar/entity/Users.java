package com.example.CreativeCar.entity;

import com.example.CreativeCar.enums.Role;
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
public class Users extends CoreEntity {
    @Column(nullable = false, unique = true)
    String username;
    String name;
    String email;
    String phone;
    String licence;
    Double balance;
    @Enumerated(EnumType.STRING)
    Role role;

    @OneToMany(mappedBy = "user")
    List<Apeal> apeals;

    @OneToMany(mappedBy = "user")
    List<Order> orders;

    @OneToMany(mappedBy = "user")
    List<Like> likes;

    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    @OneToMany(mappedBy = "user")
    List<Reply> replies;


}
