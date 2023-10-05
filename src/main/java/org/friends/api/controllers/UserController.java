package org.friends.api.controllers;

import org.friends.api.services.interfaces.UserService;
import org.friends.api.shared.dtos.CreateUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody CreateUserDto userDto) {
        userService.createUser(userDto);
        return "User created";
    }
}
