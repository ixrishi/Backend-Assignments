package com.rishi.dayseven.utils;


import com.rishi.dayseven.DTO.StudentRequestDTO;
import com.rishi.dayseven.DTO.StudentResponseDTO;
import com.rishi.dayseven.model.Student;
import org.springframework.stereotype.Component;

@Component
public class Utility {

    public Student toEntity(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        return student;
    }

    public StudentResponseDTO toResponseDTO(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        return dto;
    }
}
