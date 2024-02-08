package com.api.parking.services;

import com.api.parking.models.ParkingSpotModel;
import com.api.parking.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

    // Ponto de injeção
    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return false;
    }

    public boolean existsByParkingSpotNumber(String spotNumber) {
        return false;
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return false;
    }

}
