package com.hairtherapy.hairtherapy.dto;

import com.hairtherapy.hairtherapy.entity.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
