package com.sparta.springhomework.service;

import com.sparta.springhomework.dto.PlanRequestDto;
import com.sparta.springhomework.dto.PlanResponseDto;
import com.sparta.springhomework.repository.PlanRepository;

public class PlanService {
    PlanRepository planRepository = new PlanRepository();

    public PlanResponseDto createPlan(PlanRequestDto planRequestDto) {
        return null;
    }
}
