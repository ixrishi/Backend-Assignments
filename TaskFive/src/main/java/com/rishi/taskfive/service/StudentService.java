package com.rishi.taskfive.service;


import com.rishi.taskfive.model.StudentModel;
import com.rishi.taskfive.repo.StudentRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    ValueOperations<String,String> valueOps;

    @PostConstruct
    public void init() {
        valueOps = redisTemplate.opsForValue();
    }

    public ResponseEntity<StudentModel> getStudent(int id) {
        Optional<StudentModel> s= repo.findById(id);
        String s1 = valueOps.get("user:" + id);

        if(s1!= null){
            try{

            StudentModel studentModel = objectMapper.readValue(s1, StudentModel.class);
                return new ResponseEntity<>(studentModel, HttpStatus.OK);
            } catch (JacksonException e) {
                throw new RuntimeException(e);
            }
        }
        if(s.isPresent()){

            String userJson = objectMapper.writeValueAsString(s.get());

            valueOps.set("user:"+s.get().getId(),userJson);

            return new ResponseEntity<>(s.get(), HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<List<StudentModel>> getStudentByName(String name) {
        List<StudentModel> students= repo.findByName(name);
        System.out.println(name);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    public ResponseEntity<List<StudentModel>> getAllStudents() {
        return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String> addStudent(StudentModel student) {
         StudentModel studentModel = repo.save(student);


        String json = objectMapper.writeValueAsString(studentModel);
        valueOps.set("user:"+ studentModel.getId(),json,100, TimeUnit.SECONDS);

         return new  ResponseEntity<>("Student added Successfully",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudent(int id){
        if(repo.existsById(id)){
          repo.deleteById(id);
          redisTemplate.delete("user:"+id);
         return new ResponseEntity<>("Student deleted successfully",HttpStatus.OK);

        }
        return new  ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> updateStudent(StudentModel student, int id) {

        if(repo.existsById(id)){
            repo.save(student);
            String json = objectMapper.writeValueAsString(student);
            valueOps.set("user:"+student.getId(),json, 100,TimeUnit.SECONDS);
        return new ResponseEntity<>("Student Updated",HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }





    }

    public ResponseEntity<List<StudentModel>> getStudentsByAge(int age) {
        List<StudentModel>s  =repo.findByAgeGreaterThan(age);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
}
