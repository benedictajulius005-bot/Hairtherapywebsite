package com.hairtherapy.hairtherapy.service;

import com.hairtherapy.hairtherapy.dto.ServiceDto;
import com.hairtherapy.hairtherapy.entity.Service;

import java.util.List;

public interface ServiceService {

    Service addService(ServiceDto serviceDto);
    List<Service> getAllServices();
    Service getServiceById(int id);
    Service updateService(int id, ServiceDto serviceDto);
    void deleteService(int id);

}
