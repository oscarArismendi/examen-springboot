package com.examen.examen_springboot.infrastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.examen_springboot.application.BikeServiceImpl;
import com.examen.examen_springboot.domain.entities.Bike;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeServiceImpl bikeServiceImpl;

    @Autowired
    BikeRepository bikeRepository;

    @GetMapping("/list-all")
    public List<Bike> listAllBike() {
        return bikeServiceImpl.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBike(@Valid @RequestBody Bike bike, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        bikeServiceImpl.save(bike);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bike created successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBike(@PathVariable Long id) {
        try {
            Optional<Bike> bike = bikeServiceImpl.findAll().stream().filter(s -> s.getId().equals(id)).findFirst();
            if (bike.isPresent()) {
                bikeServiceImpl.delete(bike.get());
                return ResponseEntity.ok("Bike deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bike not found with id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting Bike: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBike(@PathVariable Long id, @Valid @RequestBody Bike updatedBike,
            BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        try {
            Optional<Bike> existingBikeOptional = bikeRepository.findById(id);
            if (existingBikeOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bike not found with id: " + id);
            }

            bikeServiceImpl.update(id, updatedBike);
            return ResponseEntity.ok("Bike updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating Bike: " + e.getMessage());
        }
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "The field " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
