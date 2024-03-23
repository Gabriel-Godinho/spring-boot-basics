package com.api.parking.services;

import com.api.parking.dtos.CarBrandDTO;
import com.api.parking.models.CarBrandModel;
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
    public CarBrandModel save(CarBrandDTO carBrandDTO) {
        CarBrandModel carBrandModel = new CarBrandModel();
        BeanUtils.copyProperties(carBrandDTO, carBrandModel);

        return carBrandRepository.save(carBrandModel);
    }

    public Optional<CarBrandModel> findById(Long id) {
        return carBrandRepository.findById(id);
    }

}
