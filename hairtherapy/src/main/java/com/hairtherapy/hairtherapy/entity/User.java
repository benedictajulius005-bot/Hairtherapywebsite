package com.hairtherapy.hairtherapy.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;        // CLIENT, STYLIST, ADMIN
}
