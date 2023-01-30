package com.example.redis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("Student")
public class Student implements Serializable {
    @Id
    private Long id;
    private String name;
    private int age;
}
