package com.example.redis.repository;

import com.example.redis.entity.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {
    public static final String HASH_KEY = "Student";
    private RedisTemplate redisTemplate;

    public Student save(Student student){
        redisTemplate.opsForHash().put(HASH_KEY, student.getId(), student);
        return student;
    }

    public List<Student> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Student findById(Long id) {
        return (Student) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public Long deleteStudent(Long id){
        return redisTemplate.opsForHash().delete(HASH_KEY, id);
    }
}
