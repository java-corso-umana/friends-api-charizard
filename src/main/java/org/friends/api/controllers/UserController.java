package org.friends.api.controllers;

import org.friends.api.services.interfaces.UserService;
import org.friends.api.shared.dtos.CreateUserDto;
import org.friends.api.shared.dtos.DeleteUserDto;
import org.friends.api.shared.dtos.LoginUserDto;
import org.friends.api.shared.dtos.UserDto;
import org.friends.api.shared.entities.UserEntity;
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

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto userDto) {
        userService.createUser(userDto);
        return new ResponseEntity<>("User created", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getList() {
        List<UserDto> allUsers;
        allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> editUser(LoginUserDto oldInfo,@RequestBody CreateUserDto newInfo) {
        userService.editUser(oldInfo, newInfo);
        return new ResponseEntity<>("User edited", HttpStatus.OK);
    }


    @GetMapping("/search/{lookup}")
    public ResponseEntity<List<UserDto>> search(@PathVariable String lookup) {
        List<UserDto> result;
        result = userService.search(lookup);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteUser(@RequestBody DeleteUserDto userDto){
        userService.deleteUser(userDto);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
