package com.hairtherapy.hairtherapy.service;

import com.hairtherapy.hairtherapy.dto.UserDto;
import com.hairtherapy.hairtherapy.entity.User;

public interface UserService {

    UserDto addUser(UserDto userDto);
    UserDto login(String email, String password);
    User getUserById(int id);
    User updateUser(int id, UserDto userDto);
}
