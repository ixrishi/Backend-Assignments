package com.rishi;

import com.rishi.service.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
         GreetingService service =context.getBean(GreetingService.class);
        service.greet();
       context.close();
    }
}