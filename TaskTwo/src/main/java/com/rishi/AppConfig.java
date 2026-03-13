package com.rishi;

import com.rishi.service.GreetingClient;
import com.rishi.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.rishi")
public class AppConfig {
//    @Bean
//    public GreetingService greetingService(){
//        return new GreetingService();
//    }
//    @Bean
//    public GreetingClient greetingClient(){
//        return new GreetingClient(greetingService());
//    }
}
