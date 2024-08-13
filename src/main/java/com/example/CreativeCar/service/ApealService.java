package com.example.CreativeCar.service;

import com.example.CreativeCar.entity.Apeal;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.enums.ApealProgress;
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

    private final UserRepository usersRepository;

    public Apeal createApeal(Long userId) {
        Optional<Users> userOptional = usersRepository.findById(userId);

        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            Apeal apeal = Apeal.builder()
                    .user(user)
                    .apealProgress(ApealProgress.ACCEPTED_0)
                    .build();

            apealRepository.save(apeal);
            return apeal;
        }
        return null;
    }

    public Apeal checkLicenseAndProgress(Long apealId) {
        Optional<Apeal> apealOptional = apealRepository.findById(apealId);

        if (apealOptional.isPresent()) {
            Apeal apeal = apealOptional.get();
            Users user = apeal.getUser();

            if (isLicenseValid(user.getLicence())) {
                apeal.setApealProgress(ApealProgress.PROGRESS_2);
            } else {
                apeal.setApealProgress(ApealProgress.REJECTED_1);
            }

            apealRepository.save(apeal);
            return apeal;
        }

        return null;
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
