package com.rishi.config;


import com.rishi.repository.UserRepository;
import com.rishi.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.rishi")
public class AppConfig {

//     @Bean
//     public UserRepository userRepository() {
//         return new UserRepository();
//     }
//
//     @Bean
//     public UserService userService(UserRepository repo) {
//         return new UserService(repo);
//     }
}