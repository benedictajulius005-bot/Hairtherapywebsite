package com.hairtherapy.hairtherapy.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Service{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private float price;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User stylist;
}
