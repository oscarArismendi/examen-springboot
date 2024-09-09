package com.examen.examen_springboot.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.examen_springboot.domain.entities.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
