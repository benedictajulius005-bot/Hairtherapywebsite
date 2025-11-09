package com.hairtherapy.hairtherapy.service.impl;

import com.hairtherapy.hairtherapy.dto.UserDto;
import com.hairtherapy.hairtherapy.entity.User;
import com.hairtherapy.hairtherapy.repository.UserRepository;
import com.hairtherapy.hairtherapy.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto addUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = mapToEntity(userDto);
        User newUser = userRepository.save(user);
        UserDto userResponse = mapToDto(newUser);
        return userResponse;
    }

    @Override
    public UserDto login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)){
            return mapToDto(user);
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(int id, UserDto userDto) {
        User user = getUserById(id);

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword()); // Ideally, encode password before saving
        user.setRole(userDto.getRole());

        return userRepository.save(user);
    }


    private User mapToEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }

    private UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
