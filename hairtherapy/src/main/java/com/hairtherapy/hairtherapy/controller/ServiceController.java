package com.hairtherapy.hairtherapy.controller;

import com.hairtherapy.hairtherapy.dto.ServiceDto;
import com.hairtherapy.hairtherapy.entity.Service;
import com.hairtherapy.hairtherapy.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping
    public ResponseEntity<Service> addService(@RequestBody ServiceDto serviceDto) {
        return ResponseEntity.ok(serviceService.addService(serviceDto));
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable int id) {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable int id, @RequestBody ServiceDto serviceDto) {
        return ResponseEntity.ok(serviceService.updateService(id, serviceDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable int id) {
        serviceService.deleteService(id);
        return ResponseEntity.ok("Service deleted successfully");
    }

}
