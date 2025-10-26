package com.hairtherapy.hairtherapy.service;

import com.hairtherapy.hairtherapy.dto.AppointmentDto;
import com.hairtherapy.hairtherapy.entity.Appointment;
import com.hairtherapy.hairtherapy.entity.AppointmentStatus;

import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(AppointmentDto appointmentDto);
    List<Appointment> getAppointmentsByClientId(int clientId);
    List<Appointment> getAppointmentsByStylistId(int stylistId);
    Appointment updateAppointmentStatus(int appointmentId, AppointmentStatus status);
    List<Appointment> getAllAppointments();
    Appointment cancelAppointment(int appointmentId);



}
