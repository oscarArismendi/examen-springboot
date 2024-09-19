package com.examen.examen_springboot.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.examen_springboot.domain.entities.SaleDetails;
import com.examen.examen_springboot.domain.services.SaleDetailsInterface;
import com.examen.examen_springboot.infrastructure.SaleDetailsRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class SaleDetailsImpl implements SaleDetailsInterface {
@Autowired
    SaleDetailsRepository saleDetailsRepository;

    @Override
    @Transactional
    public void save(SaleDetails saleDetails) {
        saleDetailsRepository.save(saleDetails);
    }

    @Override
    @Transactional
    public void delete(SaleDetails saleDetails) {
        saleDetailsRepository.delete(saleDetails);
    }

    @Override
    public void update(Long id, SaleDetails saleDetails) {
                Optional<SaleDetails> existingSaleDetailsOpt = saleDetailsRepository.findById(id);

        if (existingSaleDetailsOpt.isPresent()) {
            SaleDetails existingSaleDetails = existingSaleDetailsOpt.get();

            existingSaleDetails.setCantidad(saleDetails.getCantidad());
            existingSaleDetails.setPrecio_unitario(saleDetails.getPrecio_unitario());
            existingSaleDetails.setSale(saleDetails.getSale());
            existingSaleDetails.setBike(saleDetails.getBike());

            saleDetailsRepository.save(existingSaleDetails);
        } else {
            throw new EntityNotFoundException("Sale details not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public List<SaleDetails> findAll() {
        return saleDetailsRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<SaleDetails> findById(Long id) {
        return saleDetailsRepository.findById(id);
    }
}
