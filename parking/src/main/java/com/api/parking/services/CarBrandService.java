package com.api.parking.services;

import com.api.parking.dtos.CarBrandDTO;
import com.api.parking.models.CarBrand;
import com.api.parking.repositories.CarBrandRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<CarBrand> findById(Long id) {
        return carBrandRepository.findById(id);
    }

}
