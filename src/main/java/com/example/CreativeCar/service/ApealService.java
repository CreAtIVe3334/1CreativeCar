package com.example.CreativeCar.service;

import com.example.CreativeCar.entity.Apeal;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.enums.ApealProgress;
import com.example.CreativeCar.mapper.apeal.ApealAcceptedMapper;
import com.example.CreativeCar.repository.ApealRepository;
import com.example.CreativeCar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApealService {

    private final ApealRepository apealRepository;

    private final UserService userService;

    public Apeal createApeal(Long userId) {
        Optional<Users> user = Optional.ofNullable(userService.getUserById(userId));
        Apeal apeal = ApealAcceptedMapper.dtoToEntity(user.get());
        return apealRepository.save(apeal);
    }


    private boolean isLicenseValid(String license) {
        // compare mentiqi yazilmalidi
        return license != null && !license.isEmpty();
    }

//    @Scheduled(fixedDelay = 60000)
//    public void updateApealsInProgress() {
//        apealRepository.findByApealProgress(ApealProgress.PROGRESS_2)
//                .forEach(apeal -> {
//                    apeal.(ApealProgress.CONTINUE_3);
//                    apealRepository.save(apeal);
//                });
//    }
}
