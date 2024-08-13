package com.sparta.springhomework.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class PlanRequestDto {
    private Long id;
    private String todo;
    private String name;
    private Timestamp create_at;
    private Timestamp update_at;
}
