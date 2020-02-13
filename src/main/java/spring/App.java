package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.config.AppConfig;
import spring.model.User;
import spring.service.UserService;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User userF = new User();
        userF.setUsername("First");
        userService.add(userF);

        User userS = new User();
        userS.setUsername("Second");
        userService.add(userS);

        userService.listUsers().forEach(System.out::println);
    }
}
