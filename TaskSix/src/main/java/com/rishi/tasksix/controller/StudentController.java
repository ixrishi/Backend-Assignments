package com.rishi.tasksix.controller;

import com.rishi.tasksix.DTO.StudentRequestDTO;
import com.rishi.tasksix.DTO.StudentResponseDTO;
import com.rishi.tasksix.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
class StudentController {

    //hide sensitive data
    //performance small payload
    //can change entity sturcture without changing api

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentResponseDTO> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public StudentResponseDTO create(@RequestBody StudentRequestDTO dto) {
        return service.saveStudent(dto);
    }


    @PutMapping("/{id}")
    public StudentResponseDTO update(@PathVariable int id,
                                     @RequestBody StudentRequestDTO dto) {
        return service.updateStudent(id, dto);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteStudent(id);
        return "Deleted successfully";
    }
}
