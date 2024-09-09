package com.examen.examen_springboot.domain.services;

import java.util.List;
import java.util.Optional;

import com.examen.examen_springboot.domain.entities.Bike;

public interface BikeInterface {
    void save(Bike bike);
    void delete(Bike bike);
    void update(Long id, Bike bike);
    List<Bike>  findAll();
    Optional<Bike> findById(Long id);
}
