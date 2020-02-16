package spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import spring.UserResponseDto;
import spring.model.User;
import spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/inject")
    public ModelAndView injectUsers() {
        User first = new User();
        first.setUsername("First");
        userService.add(first);

        User second = new User();
        second.setUsername("Second");
        userService.add(second);

        User third = new User();
        third.setUsername("Third");
        userService.add(third);

        User fourth = new User();
        fourth.setUsername("Fourth");
        userService.add(fourth);

        return new ModelAndView("redirect:/user/");
    }

    @GetMapping("/get/{user_id}")
    public UserResponseDto get(@PathVariable(name = "user_id") Long userId) {
        UserResponseDto userResponseDto = new UserResponseDto();
        User userById = userService.getUserById(userId);
        userResponseDto.setId(userById.getId());
        userResponseDto.setUsername(userById.getUsername());
        return userResponseDto;
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        userService.listUsers()
                .forEach(user -> userResponseDtoList.add(new UserResponseDto(user.getId(),
                        user.getUsername())));
        return userResponseDtoList;
    }
}
