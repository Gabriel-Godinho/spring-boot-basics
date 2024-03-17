package com.api.parking.services;

import com.api.parking.models.CarBrandModel;
import com.api.parking.repositories.CarBrandRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBrandService {

    @Autowired
    CarBrandRepository carBrandRepository;

    @Transactional
    public CarBrandModel save(CarBrandModel carBrandModel) {
        return carBrandRepository.save(carBrandModel);
    }

}
