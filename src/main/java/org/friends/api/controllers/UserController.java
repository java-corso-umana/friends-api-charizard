package org.friends.api.controllers;

import org.friends.api.services.interfaces.UserService;
import org.friends.api.shared.dtos.CreateUserDto;
import org.friends.api.shared.dtos.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto userDto) {
        userService.createUser(userDto);
        return new ResponseEntity<>("User created", HttpStatus.OK);
    }

    @PostMapping("/getUsers")
    public ResponseEntity<?> getList() {
        List<UserDto> allUsers;
        allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
