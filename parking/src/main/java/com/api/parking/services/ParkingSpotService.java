package com.api.parking.services;

import com.api.parking.dtos.ParkingSpotDTO;
import com.api.parking.models.CarBrand;
import com.api.parking.models.ParkingSpot;
import com.api.parking.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Autowired
    CarBrandService carBrandService;

    @Transactional
    public ParkingSpot save(ParkingSpotDTO parkingSpotDto) {
        ParkingSpot parkingSpot = new ParkingSpot();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpot);

        parkingSpot.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        return parkingSpotRepository.save(parkingSpot);
    }

    @Transactional
    public ParkingSpot update(UUID id, ParkingSpotDTO parkingSpotDTO) {
        Optional<ParkingSpot> parkingSpotOptional = findById(id);

        if (parkingSpotOptional.isPresent()) {
            ParkingSpot parkingSpot = parkingSpotOptional.get();
            parkingSpot.setParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber());
            parkingSpot.setLicensePlateCar(parkingSpotDTO.getLicensePlateCar());
            parkingSpot.setCarModel(parkingSpotDTO.getCarModel());
            parkingSpot.setCarColor(parkingSpotDTO.getCarColor());
            parkingSpot.setResponsibleName(parkingSpotDTO.getResponsibleName());
            parkingSpot.setApartment(parkingSpotDTO.getApartment());
            parkingSpot.setBlock(parkingSpotDTO.getBlock());

            Optional<CarBrand> carBrandOptional = carBrandService.findById(parkingSpotDTO.getCarBrandId());
            carBrandOptional.ifPresent(parkingSpot::setCarBrandId);

            return parkingSpotRepository.save(parkingSpot);
        }

        return null;
    }

    @Transactional
    public void delete(ParkingSpot parkingSpot) {
        parkingSpotRepository.delete(parkingSpot);
    }

    public Optional<ParkingSpot> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    public Page<ParkingSpot> findAll(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String spotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(spotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }

}
