package org.friends.api.services.interfaces;

import org.apache.catalina.User;
import org.friends.api.shared.dtos.CreateUserDto;
import org.friends.api.shared.dtos.LoginUserDto;
import org.friends.api.shared.dtos.UserDto;
import org.friends.api.shared.dtos.DeleteUserDto;
import org.friends.api.shared.entities.UserEntity;

import java.util.List;

public interface UserService {
    void createUser(CreateUserDto createUserDto);
    List<UserDto> getAllUsers();
    void editUser(LoginUserDto oldInfo, CreateUserDto newInfo);
    List<UserDto> search(String lookup);
    void deleteUser (DeleteUserDto deleteUserDto);
}
