package com.rishi.taskfive.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class StudentModel {
    @Id //auto:hybernate decide whether to choose identity or sequence
    //identity : Auto-increment column, during insert , slow
    //sequence: Database sequence object , Before INSERT ,  fast
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    @Column(name = "age")
    int age;
}
