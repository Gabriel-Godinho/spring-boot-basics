package com.api.parking.controllers;

import com.api.parking.dtos.CarBrandDTO;
import com.api.parking.models.CarBrand;
import com.api.parking.services.CarBrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/car-brand")
public class CarBrandController {

    @Autowired
    CarBrandService carBrandService;

    @GetMapping("get-all")
    public ResponseEntity<Object> getAllCarBrands(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(carBrandService.findAll(pageable));
    }

    @PostMapping("/save-car-brand")
    public ResponseEntity<Object> save(@Valid @RequestBody CarBrandDTO carBrandDTO) {
        if (carBrandService.existsByBrandName()) {
            String conflictMessage = "Bad request: Brand already saved!";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(conflictMessage);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(carBrandService.save(carBrandDTO));
    }

    @DeleteMapping("delete-car-brand/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
        Optional<CarBrand> carBrand = carBrandService.findById(id);

        if (carBrand.isPresent()) {
            carBrandService.delete(carBrand.get());

            String successMessage = "Car brand delete successfully!";
            return ResponseEntity.ok(successMessage);
        }

        String notFoundMessage = "Car brand not found to be deleted!";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundMessage);
    }

}