package com.rishi;

import com.rishi.config.AppConfig;
import com.rishi.model.User;
import com.rishi.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        try{


            UserService service = context.getBean(UserService.class);

            System.out.println("All users:");
            service.getAllUsers().forEach(System.out::println);

            System.out.println("\nCreating new user...");
            Optional<User> newUser = service.createUser(4,"Samay", "smay@gmail.com","Mumbai");
            if(newUser.isEmpty()){
                System.out.println("Error in creatin the user");
            }
            else{
            System.out.println("Created → " + newUser);

            }

            System.out.println("\nAll users:");
            System.out.println(service.getAllUsers());

            System.out.println("\nUser:");
            Optional<User> op=service.getUser(1);
            if(op.isEmpty())System.out.println("user not Found");
            else{
                System.out.println(op.get());
            }

          BeanLifeCycle cycle =context.getBean(BeanLifeCycle.class) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            context.close();
        }

    }
}