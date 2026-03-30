package com.rishi.dayseven.controller;

import com.rishi.dayseven.DTO.StudentRequestDTO;
import com.rishi.dayseven.DTO.StudentResponseDTO;
import com.rishi.dayseven.GlobalExceptionHandler;
import com.rishi.dayseven.customExceptions.UserNotFoundException;
import com.rishi.dayseven.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
class StudentController {

    //hide sensitive data
    //performance small payload
    //can change entity sturcture without changing api

    public StudentController(StudentService service, GlobalExceptionHandler globalExceptionHandler) {
        this.service = service;
        this.globalExceptionHandler = globalExceptionHandler;
    }

    private final StudentService service;


    private  final  GlobalExceptionHandler globalExceptionHandler;



    @GetMapping
    public List<StudentResponseDTO> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public StudentResponseDTO create(@Valid @RequestBody StudentRequestDTO dto) {
        return service.saveStudent(dto);
    }


    @PutMapping("/{id}")
    public StudentResponseDTO update(@PathVariable int id,
                                     @Valid  @RequestBody StudentRequestDTO dto) {
        return service.updateStudent(id, dto);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteStudent(id);
        return "Deleted successfully";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(UserNotFoundException ex) {
        return globalExceptionHandler.buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
