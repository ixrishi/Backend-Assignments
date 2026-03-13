package com.rishi.taskthree;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskThreeApplication implements CommandLineRunner {
    @Value("${app.message}")
    public String msg;

    @PostConstruct
    public  void display(){
        System.out.println(msg);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("This printed using run:" +msg);
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskThreeApplication.class, args);
    }

}
