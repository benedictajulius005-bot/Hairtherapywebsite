package com.hairtherapy.hairtherapy.service;

import com.hairtherapy.hairtherapy.dto.ServiceDto;
import com.hairtherapy.hairtherapy.entity.Role;
import com.hairtherapy.hairtherapy.entity.Service;
import com.hairtherapy.hairtherapy.entity.User;
import com.hairtherapy.hairtherapy.repository.ServiceRepository;
import com.hairtherapy.hairtherapy.repository.UserRepository;
import com.hairtherapy.hairtherapy.service.impl.ServiceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceServiceImplTest {

    @Mock
    private ServiceRepository serviceRepository;

    @Mock
    private UserRepository userRepository;


    @InjectMocks
    private ServiceServiceImpl serviceService;

    @Test
    void testAddService_Success() {
        // Mock stylist (since your code expects stylist to exist in DB)
        User stylist = new User(1, "Emma", "emma@example.com", "12345", Role.STYLIST);

        // Mock input DTO
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setName("Hair Wash");
        serviceDto.setDescription("Simple wash");
        serviceDto.setPrice(10.0f);
        serviceDto.setDuration(30);
        serviceDto.setStylistId(1);

        // Mock repository calls
        when(userRepository.findById(1)).thenReturn(Optional.of(stylist));
        when(serviceRepository.save(any(com.hairtherapy.hairtherapy.entity.Service.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Run method
        com.hairtherapy.hairtherapy.entity.Service result = serviceService.addService(serviceDto);

        // Assertions
        assertNotNull(result);
        assertEquals("Hair Wash", result.getName());
        assertEquals(stylist, result.getStylist());

        verify(userRepository, times(1)).findById(1);
        verify(serviceRepository, times(1)).save(any(com.hairtherapy.hairtherapy.entity.Service.class));
    }

}
