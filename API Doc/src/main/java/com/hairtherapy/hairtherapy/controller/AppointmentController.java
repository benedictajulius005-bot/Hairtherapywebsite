package com.hairtherapy.hairtherapy.controller;

import com.hairtherapy.hairtherapy.dto.AppointmentDto;
import com.hairtherapy.hairtherapy.entity.Appointment;
import com.hairtherapy.hairtherapy.entity.AppointmentStatus;
import com.hairtherapy.hairtherapy.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public Appointment bookAppointment(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.bookAppointment(appointmentDto);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByClient(@PathVariable int clientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByClientId(clientId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/stylist/{stylistId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByStylist(@PathVariable int stylistId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByStylistId(stylistId);
        return ResponseEntity.ok(appointments);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Appointment> updateAppointmentStatus(
            @PathVariable int id,
            @RequestParam AppointmentStatus value) {

        Appointment updatedAppointment = appointmentService.updateAppointmentStatus(id, value);
        return ResponseEntity.ok(updatedAppointment);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable int id) {
        Appointment cancelledAppointment = appointmentService.cancelAppointment(id);
        return ResponseEntity.ok(cancelledAppointment);
    }



}
