package com.hairtherapy.hairtherapy.service.impl;

import com.hairtherapy.hairtherapy.dto.AppointmentDto;
import com.hairtherapy.hairtherapy.entity.*;
import com.hairtherapy.hairtherapy.repository.*;
import com.hairtherapy.hairtherapy.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceRepository serviceRepository;



    @Override
    public Appointment bookAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();

        User client = userRepository.findById(appointmentDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        User stylist = userRepository.findById(appointmentDto.getStylistId())
                .orElseThrow(() -> new RuntimeException("Stylist not found"));


        if (client.getRole() != Role.CLIENT)
            throw new RuntimeException("User is not a client");
        if (stylist.getRole() != Role.STYLIST)
            throw new RuntimeException("User is not a stylist");

        Service service = serviceRepository.findById(appointmentDto.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        appointment.setBookingTime(appointmentDto.getBookingTime());
        appointment.setClient(client);
        appointment.setStylist(stylist);
        appointment.setService(service);
       // appointment.setStatus("PENDING");
        appointment.setStatus(AppointmentStatus.PENDING);
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsByClientId(int clientId) {
        User client = userRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        return appointmentRepository.findByClient(client);
    }

    @Override
    public List<Appointment> getAppointmentsByStylistId(int stylistId) {
        User stylist = userRepository.findById(stylistId)
                .orElseThrow(() -> new RuntimeException("Stylist not found"));
        return appointmentRepository.findByStylist(stylist);
    }

    @Override
    public Appointment updateAppointmentStatus(int appointmentId, AppointmentStatus status) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment cancelAppointment(int appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
            throw new RuntimeException("Appointment already cancelled");
        }

        appointment.setStatus(AppointmentStatus.CANCELLED);
        return appointmentRepository.save(appointment);
    }


    /*private Appointment mapToEntity(AppointmentDto appointmentDto){
        Appointment appointment = new Appointment();
        appointment.setBookingTime(appointmentDto.getBookingTime());

    }

     */
}
