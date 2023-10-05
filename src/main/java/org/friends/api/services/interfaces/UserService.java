package org.friends.api.services.interfaces;

import org.friends.api.shared.dtos.CreateUserDto;

public interface UserService {
    void createUser(CreateUserDto createUserDto);
}
