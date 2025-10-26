package com.hairtherapy.hairtherapy.dto;

import lombok.Data;

@Data
public class ServiceDto {

    private String name;
    private String description;
    private float price;
    private int duration;
    private int stylistId;
}
