package com.rishi.tasksix.service;

import com.rishi.tasksix.DTO.StudentRequestDTO;
import com.rishi.tasksix.DTO.StudentResponseDTO;
import com.rishi.tasksix.model.Student;
import com.rishi.tasksix.repo.StudentRepo;
import com.rishi.tasksix.utils.Utility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private  StudentRepo repo;

    private  Utility utility;

    @Autowired
    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    @Autowired
    public StudentService(Utility utility) {

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
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return utility.toResponseDTO(student);
    }

    @Transactional
    public StudentResponseDTO saveStudent(StudentRequestDTO dto) {

        Student student = utility.toEntity(dto);
        Student saved = repo.save(student);

        return utility.toResponseDTO(saved);
    }

    @Transactional
    public StudentResponseDTO updateStudent(int id, StudentRequestDTO dto) {

        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        return utility.toResponseDTO(repo.save(student));
    }

    @Transactional
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}
