package com.hairtherapy.hairtherapy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime bookingTime;
    //private String status = "PENDING";
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status = AppointmentStatus.PENDING;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "stylist_id")
    private User stylist;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
}
