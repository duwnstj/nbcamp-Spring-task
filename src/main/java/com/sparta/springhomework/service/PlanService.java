package com.sparta.springhomework.service;

import com.sparta.springhomework.dto.PlanRequestDto;
import com.sparta.springhomework.dto.PlanResponseDto;
import com.sparta.springhomework.entity.Plan;
import com.sparta.springhomework.repository.PlanRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PlanService {

    private final JdbcTemplate jdbcTemplate;

    public PlanService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PlanResponseDto createPlan(PlanRequestDto requestDto) {

        //RequestDto -> Entity
        Plan plan = new Plan(requestDto);
        PlanRepository planRepository = new PlanRepository(jdbcTemplate);
        Plan savePlan = planRepository.save(plan);

        //Entity -> ResponseDto
        PlanResponseDto responseDto = new PlanResponseDto(plan);

        return responseDto;
    }

    public List<PlanResponseDto> getPlan(Long id) {
        PlanRepository planRepository = new PlanRepository(jdbcTemplate);
        return planRepository.filndbyId(id);
    }
}
