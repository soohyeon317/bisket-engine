package com.bisket.engine.controller;

import com.bisket.engine.service.SafetyOfficinalSaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/safety-officinal-sales")
@Slf4j
public class SafetyOfficinalSaleController {
    private final SafetyOfficinalSaleService safetyOfficinalSaleService;

    public SafetyOfficinalSaleController(SafetyOfficinalSaleService safetyOfficinalSaleService) {
        this.safetyOfficinalSaleService = safetyOfficinalSaleService;
    }

}
