package com.hairtherapy.hairtherapy.service.impl;

import com.hairtherapy.hairtherapy.dto.ServiceDto;
import com.hairtherapy.hairtherapy.entity.User;
import com.hairtherapy.hairtherapy.repository.ServiceRepository;
import com.hairtherapy.hairtherapy.repository.UserRepository;
import com.hairtherapy.hairtherapy.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;

    @Override
    public com.hairtherapy.hairtherapy.entity.Service addService(ServiceDto serviceDto) {
        User stylist = userRepository.findById(serviceDto.getStylistId())
                .orElseThrow(() -> new RuntimeException("Stylist not found"));

        com.hairtherapy.hairtherapy.entity.Service service = new com.hairtherapy.hairtherapy.entity.Service();
        service.setName(serviceDto.getName());
        service.setDescription(serviceDto.getDescription());
        service.setPrice(serviceDto.getPrice());
        service.setDuration(serviceDto.getDuration());
        service.setStylist(stylist);

        return serviceRepository.save(service);
    }

    @Override
    public List<com.hairtherapy.hairtherapy.entity.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public com.hairtherapy.hairtherapy.entity.Service getServiceById(int id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
    }

    @Override
    public com.hairtherapy.hairtherapy.entity.Service updateService(int id, ServiceDto serviceDto) {
        com.hairtherapy.hairtherapy.entity.Service existing = getServiceById(id);

        existing.setName(serviceDto.getName());
        existing.setDescription(serviceDto.getDescription());
        existing.setPrice(serviceDto.getPrice());
        existing.setDuration(serviceDto.getDuration());

        return serviceRepository.save(existing);
    }

    @Override
    public void deleteService(int id) {

        serviceRepository.deleteById(id);
    }
}
