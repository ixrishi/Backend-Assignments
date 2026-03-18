package com.rishi.taskfive.repo;


import com.rishi.taskfive.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//hybernate : ORM Maping , sql generation
//jpa is an interface so actual implementation lies in StudentRepositoryImpl class , which is created runtime by spring boot
@Repository
public interface StudentRepo  extends JpaRepository<StudentModel,Integer> {

    List<StudentModel> findAllByName(String name);

    List<StudentModel> findByName(String name);

    List<StudentModel> findByNameAndId(String name, int id);


@Query("select s from StudentModel s where s.age > :age")
    List<StudentModel> findByAgeGreaterThan(int age);
}
