package com.hairtherapy.hairtherapy.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDto {

    private int id;
    private LocalDateTime bookingTime;

    private int serviceId;
    private int stylistId;
    private int clientId;
}
