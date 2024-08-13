package com.sparta.springhomework.entity;

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
}
