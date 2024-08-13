package com.example.CreativeCar.mapper.apeal;

import com.example.CreativeCar.entity.Apeal;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.enums.ApealProgress;

public class ApealAcceptedMapper {
    public static Apeal dtoToEntity(Users user){
        return Apeal.builder()
                .user(user)
                .apealProgress(ApealProgress.ACCEPTED_0)
                .build();
    }
}
