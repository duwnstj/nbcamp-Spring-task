package com.sparta.springhomework.controller;

import com.sparta.springhomework.dto.PlanRequestDto;
import com.sparta.springhomework.dto.PlanResponseDto;
import com.sparta.springhomework.service.PlanService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanController {
    private final JdbcTemplate jdbcTemplate;

    public PlanController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/plans")
    // 일정 생성
    public PlanResponseDto createPlan(@RequestBody PlanRequestDto requestDto) {
        PlanService planService = new PlanService(jdbcTemplate);
        return planService.createPlan(requestDto);

    }

    @GetMapping("/plans/{id}")
    //일정 단건 조회
    public List<PlanResponseDto> getPlan(@PathVariable Long id) {
        PlanService planService = new PlanService(jdbcTemplate);
        return planService.getPlan(id);
    }


}
