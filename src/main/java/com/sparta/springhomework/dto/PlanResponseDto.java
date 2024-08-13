package com.sparta.springhomework.dto;

import com.sparta.springhomework.entity.Plan;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class PlanResponseDto {
    private Long id;
    private String todo;
    private String name;
    private Timestamp create_at;
    private Timestamp update_at;

    public PlanResponseDto(Plan plan) {
        this.id = plan.getId();
        this.todo = plan.getTodo();
        this.name = plan.getName();
        this.create_at = plan.getCreate_at();
        this.update_at = plan.getUpdate_at();
    }


    public PlanResponseDto(Long id, String todo, String name, Timestamp create_at, Timestamp update_at) {
        this.id = id;
        this.todo = todo;
        this.name = name;
        this.create_at = create_at;
        this.update_at = update_at;
    }
}




