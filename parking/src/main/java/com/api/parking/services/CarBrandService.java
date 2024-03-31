package com.api.parking.services;

import com.api.parking.dtos.CarBrandDTO;
import com.api.parking.models.CarBrand;
import com.api.parking.repositories.CarBrandRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarBrandService {

    @Autowired
    CarBrandRepository carBrandRepository;

    @Transactional
    public CarBrand save(CarBrandDTO carBrandDTO) {
        CarBrand carBrand = new CarBrand();
        BeanUtils.copyProperties(carBrandDTO, carBrand);

        return carBrandRepository.save(carBrand);
    }

    @Transactional
    public void delete(CarBrand carBrand) {
        carBrandRepository.delete(carBrand);
    }

    public Optional<CarBrand> findById(Long id) {
        return carBrandRepository.findById(id);
    }

    public Page<CarBrand> findAll(Pageable pageable) {
        return carBrandRepository.findAll(pageable);
    }

    public boolean existsByBrandName() {
        return carBrandRepository.existsByBrandName();
    }

}
