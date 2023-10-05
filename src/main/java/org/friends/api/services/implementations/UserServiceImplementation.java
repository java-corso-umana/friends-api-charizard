package org.friends.api.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.friends.api.repositories.UserRepository;
import org.friends.api.services.interfaces.UserService;
import org.friends.api.shared.dtos.CreateUserDto;
import org.friends.api.shared.dtos.DeleteUserDto;
import org.friends.api.shared.dtos.LoginUserDto;
import org.friends.api.shared.dtos.UserDto;
import org.friends.api.shared.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<UserDto> getAllUsers() {
        List<UserDto> allUsers = new ArrayList<>();
        for (UserEntity userEntity : userRepository.findAll()) {
            UserDto userDto = new UserDto();
            userDto.setUsername(userEntity.getUsername());
            userDto.setFirstName(userEntity.getName());
            userDto.setLastName(userEntity.getSurname());

            allUsers.add(userDto);
        }
        return allUsers;
    }

    @Override
    public void deleteUser(DeleteUserDto deleteUserDto){
        log.info("Deleting user: {}", deleteUserDto);
        UserEntity user = new UserEntity();
    }

    // impl su user controller
    @Override
    public void editUser(LoginUserDto oldInfo, CreateUserDto newInfo) {
        log.info("Edit user {}", oldInfo);
//        UserEntity toEdit = userRepository.findByUsername(oldInfo.getUsername());




        /*if (newInfo.getUsername() != null){
            oldInfo.setUsername(newInfo.getUsername());
        }
        if (newInfo.getFirstName() != null){
            oldInfo.(newInfo.getFirstName());
        }
        if (newInfo.getLastName() != null){
            oldInfo.setSurname(newInfo.getLastName());
        }
        userRepository.save(oldInfo);*/
    }

    public void login(LoginUserDto userDto){

    }


    public List<UserDto> search(String lookup) {
        List<UserDto> result = new ArrayList<>();

        for (UserEntity userEntity : userRepository.findAll()) {
            String compareFullName = userEntity.getName() + " " + userEntity.getSurname();
            UserDto userDto = new UserDto();
            if ( lookup.length() == 1 ) {
                if (
                    userEntity.getUsername().toLowerCase().startsWith(lookup.toLowerCase()) ||
                    userEntity.getName().toLowerCase().startsWith(lookup.toLowerCase()) ||
                    userEntity.getSurname().toLowerCase().startsWith(lookup.toLowerCase())
                ) {
                    userDto.setUsername(userEntity.getUsername());
                    userDto.setFirstName(userEntity.getName());
                    userDto.setLastName(userEntity.getSurname());
                    result.add(userDto);
                }
            } else {
                if (
                    userEntity.getUsername().toLowerCase().contains(lookup.toLowerCase()) ||
                    compareFullName.toLowerCase().contains(lookup.toLowerCase())
                ) {
                    userDto.setUsername(userEntity.getUsername());
                    userDto.setFirstName(userEntity.getName());
                    userDto.setLastName(userEntity.getSurname());
                    result.add(userDto);
                }
            }
        }

        return result;
    }
}
