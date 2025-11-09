package com.hairtherapy.hairtherapy.service;

import com.hairtherapy.hairtherapy.dto.AppointmentDto;
import com.hairtherapy.hairtherapy.entity.Appointment;
import com.hairtherapy.hairtherapy.entity.Role;
import com.hairtherapy.hairtherapy.entity.Service;
import com.hairtherapy.hairtherapy.entity.User;
import com.hairtherapy.hairtherapy.repository.AppointmentRepository;
import com.hairtherapy.hairtherapy.repository.ServiceRepository;
import com.hairtherapy.hairtherapy.repository.UserRepository;
import com.hairtherapy.hairtherapy.service.impl.AppointmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppointmentServiceImplTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ServiceRepository serviceRepository;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @Test
    void testBookAppointment_Success() {
        AppointmentDto dto = new AppointmentDto();
        dto.setClientId(1);
        dto.setStylistId(2);
        dto.setServiceId(1);
        dto.setBookingTime(LocalDateTime.now().plusDays(1));

        User client = new User(1, "Ali", "ali@gmail.com", "13354", Role.CLIENT);
        User stylist = new User(2, "Emma", "emma@gmail.com", "1234", Role.STYLIST);
        Service service = new Service(1, "Hair Cut", "Nice cut", 30, 60, stylist);

        when(userRepository.findById(1)).thenReturn(Optional.of(client));
        when(userRepository.findById(2)).thenReturn(Optional.of(stylist));
        when(serviceRepository.findById(1)).thenReturn(Optional.of(service));
        when(appointmentRepository.save(any(Appointment.class))).thenAnswer(inv -> inv.getArgument(0));

        Appointment result = appointmentService.bookAppointment(dto);

        assertNotNull(result);
        assertEquals(Role.CLIENT, client.getRole());
        verify(appointmentRepository, times(1)).save(any(Appointment.class));
    }

}
