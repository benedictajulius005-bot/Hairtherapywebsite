package com.hairtherapy.hairtherapy.repository;

import com.hairtherapy.hairtherapy.entity.Appointment;
import com.hairtherapy.hairtherapy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByClient(User client);
    List<Appointment> findByStylist(User stylist);
}
