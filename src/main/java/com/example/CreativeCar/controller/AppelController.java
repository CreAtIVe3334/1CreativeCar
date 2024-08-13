package com.example.CreativeCar.controller;

import com.example.CreativeCar.entity.Apeal;
import com.example.CreativeCar.service.ApealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apeals")
@RequiredArgsConstructor
public class AppelController {

    private final ApealService apealService;

    @PostMapping("/create/{userId}")
    public Apeal createApeal(@PathVariable Long userId) {
        return apealService.createApeal(userId);
    }

    @PostMapping("/check-license/{apealId}")
    public Apeal checkLicenseAndProgress(@PathVariable Long apealId) {
        return apealService.checkLicenseAndProgress(apealId);
    }
}
