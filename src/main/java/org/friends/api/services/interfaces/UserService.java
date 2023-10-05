package org.friends.api.services.interfaces;

import org.friends.api.shared.dtos.CreateUserDto;
import org.friends.api.shared.entities.UserEntity;

import java.util.List;

public interface UserService {
    void createUser(CreateUserDto createUserDto);
    List<UserEntity> getAllUsers();
}
