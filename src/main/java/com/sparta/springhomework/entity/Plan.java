package com.sparta.springhomework.entity;

import com.sparta.springhomework.dto.PlanRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor

public class Plan {
    private Long id;
    private String todo;
    private String name;
    private String password;
    private Timestamp create_at;
    private Timestamp update_at;

    public Plan(PlanRequestDto requestDto) {
        this.id = requestDto.getId();
        this.todo = requestDto.getTodo();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.create_at = requestDto.getCreate_at();
        this.update_at = requestDto.getUpdate_at();

    }
}
