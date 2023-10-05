package org.friends.api.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.friends.api.repositories.UserRepository;
import org.friends.api.services.interfaces.UserService;
import org.friends.api.shared.dtos.CreateUserDto;
import org.friends.api.shared.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(CreateUserDto createUserDto) {
        log.info("Creating user: {}", createUserDto);
        UserEntity user = new UserEntity();

        user.setUsername(createUserDto.getUsername());
        user.setPassword(createUserDto.getPassword());
        user.setName(createUserDto.getFirstName());
        user.setSurname(createUserDto.getLastName());

        userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
