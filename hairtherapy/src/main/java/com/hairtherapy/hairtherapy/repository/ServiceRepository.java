package com.hairtherapy.hairtherapy.repository;

import com.hairtherapy.hairtherapy.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
