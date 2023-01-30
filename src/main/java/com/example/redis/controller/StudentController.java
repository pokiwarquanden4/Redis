package com.example.redis.controller;

import com.example.redis.entity.Student;
import com.example.redis.model.ResponseStudent;
import com.example.redis.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/create")
    public ResponseEntity<ResponseStudent> createStudent(@RequestBody Student student){
        Student data = studentRepo.save(student);
        return data == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseStudent("false", "Can not save student", "")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseStudent("true", "Successfully", data)
                );
    }

    @PostMapping("/getAll")
    public ResponseEntity<ResponseStudent> getAllStudent() {
        List<Student> students = studentRepo.findAll();
        return students.isEmpty() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseStudent("false", "Can not get all student", "")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseStudent("true", "Successfully", students)
                );
    }

    @PostMapping("/getById/{id}")
    public ResponseEntity<ResponseStudent> getAllStudent(@PathVariable Long id) {
        Student student = studentRepo.findById(id);
        return student == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseStudent("false", "Can not get student with id: " + id , "")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseStudent("true", "Successfully", student)
                );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStudent> deleteStudent(@PathVariable Long id){
        Long results = studentRepo.deleteStudent(id);
        return results == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseStudent("false", "Can not delete student with idkkkkkkkkkkkkm : " + id , "")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseStudent("true", "Successfully", "")
                );
    }

}
