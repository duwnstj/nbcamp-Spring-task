package com.sparta.springhomework.repository;

import com.sparta.springhomework.dto.PlanResponseDto;
import com.sparta.springhomework.entity.Plan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;

public class PlanRepository {
    private final JdbcTemplate jdbcTemplate;

    public PlanRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Plan save(Plan plan) {
        // DB 저장
        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체

        String sql = "INSERT INTO plan (todo,name,password) VALUES ( ?,?,?)";
        jdbcTemplate.update(con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setString(1, plan.getTodo());
                    preparedStatement.setString(2, plan.getName());
                    preparedStatement.setString(3, plan.getPassword());


                    return preparedStatement;
                },
                keyHolder);

        // DB Insert 후 받아온 기본키 확인
        Long id = keyHolder.getKey().longValue();
        plan.setId(id);

        return plan;
    }

    public List<PlanResponseDto> filndbyId(Long id) {
        //DB 조회
        String sql = "SELECT * FROM plan where id = ?";

        return jdbcTemplate.query(sql, new RowMapper<PlanResponseDto>() {
            @Override
            public PlanResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String todo = rs.getString("todo");
                String name = rs.getString("name");
                String password = rs.getString("password");
                Timestamp create_at = rs.getTimestamp("create_at");
                Timestamp update_at = rs.getTimestamp("update_at");
                return new PlanResponseDto(id, todo, name, password, create_at, update_at);
            }
        });
    }

}
