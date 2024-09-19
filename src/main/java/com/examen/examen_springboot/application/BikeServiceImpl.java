package com.examen.examen_springboot.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.examen_springboot.domain.entities.Bike;
import com.examen.examen_springboot.domain.services.BikeInterface;
import com.examen.examen_springboot.infrastructure.BikeRepository;
import com.examen.examen_springboot.infrastructure.SaleDetailsRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class BikeServiceImpl implements BikeInterface {

    @Autowired
    BikeRepository bikeRepository;

    @Autowired
    SaleDetailsRepository saleDetailsRepository;

    @Override
    @Transactional
    public void save(Bike bike) {
        bikeRepository.save(bike);
    }

    @Override
    @Transactional
    public void delete(Bike bike) {
        saleDetailsRepository.deleteByBike(bike);
        bikeRepository.delete(bike);
    }

    @Override
    public void update(Long id, Bike bike) {
                Optional<Bike> existingBikeOpt = bikeRepository.findById(id);

        if (existingBikeOpt.isPresent()) {
            Bike existingBike = existingBikeOpt.get();

            existingBike.setModel(bike.getModel());
            existingBike.setBrand(bike.getBrand());
            existingBike.setPrecio(bike.getPrecio());
            existingBike.setStock(bike.getStock());

            bikeRepository.save(existingBike);
        } else {
            throw new EntityNotFoundException("Bike not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Bike> findById(Long id) {
        return bikeRepository.findById(id);
    }

}
