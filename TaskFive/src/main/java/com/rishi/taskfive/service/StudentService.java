package com.rishi.taskfive.service;


import com.rishi.taskfive.model.StudentModel;
import com.rishi.taskfive.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;

    public ResponseEntity<StudentModel> getStudent(int id) {
        Optional<StudentModel> s= repo.findById(id);
        if(s.isPresent()){
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
         repo.save(student);
         return new  ResponseEntity<>("Student added Successfully",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudent(int id){
        if(repo.existsById(id)){
          repo.deleteById(id);
         return new ResponseEntity<>("Student deleted successfully",HttpStatus.OK);

        }
        return new  ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> updateStudent(StudentModel student, int id) {

        if(repo.existsById(id)){
            repo.save(student);
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
