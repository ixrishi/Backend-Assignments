package com.rishi.tasksix.repo;


import com.rishi.tasksix.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
