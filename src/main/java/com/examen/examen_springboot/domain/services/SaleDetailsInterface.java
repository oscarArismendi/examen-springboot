package com.examen.examen_springboot.domain.services;

import java.util.List;
import java.util.Optional;

import com.examen.examen_springboot.domain.entities.SaleDetails;

public interface SaleDetailsInterface {
    void save(SaleDetails saleDetails);
    void delete(SaleDetails saleDetails);
    void update(Long id, SaleDetails saleDetails);
    List<SaleDetails> findAll();
    Optional<SaleDetails> findById(Long id);
}
