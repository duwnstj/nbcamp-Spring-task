package com.sparta.springhomework.controller;

import com.sparta.springhomework.dto.PlanRequestDto;
import com.sparta.springhomework.dto.PlanResponseDto;
import com.sparta.springhomework.service.PlanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlanController {
    @PostMapping("/plans")
    public PlanResponseDto createPlan(@RequestBody PlanRequestDto planRequestDto) {
        PlanService planService = new PlanService();
        return planService.createPlan(planRequestDto);

    }


}
