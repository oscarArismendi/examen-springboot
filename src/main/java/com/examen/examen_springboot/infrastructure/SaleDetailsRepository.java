package com.examen.examen_springboot.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.examen_springboot.domain.entities.Bike;
import com.examen.examen_springboot.domain.entities.SaleDetails;

public interface SaleDetailsRepository extends JpaRepository<SaleDetails, Long> {
    void deleteByBike(Bike bike);
}
