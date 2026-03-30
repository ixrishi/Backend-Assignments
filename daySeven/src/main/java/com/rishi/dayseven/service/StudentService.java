package com.rishi.dayseven.service;


import com.rishi.dayseven.DTO.StudentRequestDTO;
import com.rishi.dayseven.DTO.StudentResponseDTO;
import com.rishi.dayseven.GlobalExceptionHandler;
import com.rishi.dayseven.customExceptions.AppException;
import com.rishi.dayseven.customExceptions.UserNotFoundException;
import com.rishi.dayseven.model.Student;
import com.rishi.dayseven.repo.StudentRepo;
import com.rishi.dayseven.utils.Utility;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

//    @Autowired
    private StudentRepo repo;
//    @Autowired
    private Utility utility;

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @Autowired
    public StudentService(StudentRepo repo, Utility utility) {
        this.repo = repo;
        this.utility = utility;
    }


    public List<StudentResponseDTO> getAllStudents() {



        List<Student> students = repo.findAll();
        List<StudentResponseDTO> responseList = new ArrayList<>();

        for (Student student : students) {
            responseList.add(utility.toResponseDTO(student));
        }

        return responseList;

    }


    public StudentResponseDTO getStudentById(int id) {

        Student student = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Student not found with id:"+id));

        return utility.toResponseDTO(student);
    }

   @Transactional
    public StudentResponseDTO saveStudent( StudentRequestDTO dto) {

        Student student = utility.toEntity(dto);
        Student saved = repo.save(student);


        return utility.toResponseDTO(saved);

    }

    @Transactional

    public StudentResponseDTO updateStudent(int id, StudentRequestDTO dto) {

        Student student = repo.findById(id)
                .orElseThrow(() -> new AppException("Student not found with id:"+id , HttpStatus.NOT_FOUND));

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        return utility.toResponseDTO(repo.save(student));
    }

    @Transactional
    public void deleteStudent(int id) {
        if(repo.existsById(id))
        repo.deleteById(id);
        else {
            throw  new UserNotFoundException("Student not Found with id:"+id);
        }
    }


}
