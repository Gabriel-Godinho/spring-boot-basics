package com.api.parking.controllers;

import com.api.parking.dtos.CarBrandDTO;
import com.api.parking.services.CarBrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/car-brand")
public class CarBrandController {

    @Autowired
    CarBrandService carBrandService;

    @PostMapping("/save-car-brand")
    public ResponseEntity<Object> save(@Valid @RequestBody CarBrandDTO carBrandDTO) {
        if (carBrandService.existsByBrandName()) {
            String conflictMessage = "Bad request: Brand already saved!";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(conflictMessage);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(carBrandService.save(carBrandDTO));
    }

}