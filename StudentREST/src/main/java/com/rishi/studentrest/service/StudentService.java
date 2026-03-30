package com.rishi.studentrest.service;

import com.rishi.studentrest.model.StudentModel;
import com.rishi.studentrest.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public ResponseEntity<StudentModel> getStudent(int id) {
        return repo.getStudent(id);

    }

    public ResponseEntity<List<StudentModel>> getStudentByName(String name) {
        return repo.getStudentByName(name);
    }

    public ResponseEntity<List<StudentModel>> getAllStudents() {
        return repo.getAllStudents();
    }

    public ResponseEntity<String> addStudent(StudentModel student) {
        ValueOperations<String,String> valueOps = redisTemplate.opsForValue();
        valueOps.set("user",);
        return repo.addStudent(student);
    }

    public ResponseEntity<String> deleteStudent(int id){
        return repo.deleteStudent(id);
    }

    public ResponseEntity<String> updateStudent(StudentModel student, int id) {

        if(repo.deleteStudent(id).getStatusCode() == HttpStatus.NOT_FOUND){
            return new ResponseEntity<>("user not found ",HttpStatus.NOT_FOUND);
        }

        repo.addStudent(student);

        return new ResponseEntity<>("Student Updated",HttpStatus.OK);


    }
}
