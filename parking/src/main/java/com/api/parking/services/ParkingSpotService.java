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

    // Caso alguma dê errado durante operações de inserção ou remoção, o @Transactional garante o rollback e retorna tudo ao normal
    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }
}
