package com.api.parking.services;

import com.api.parking.dtos.ParkingSpotDTO;
import com.api.parking.models.CarBrandModel;
import com.api.parking.models.ParkingSpotModel;
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
    public ParkingSpotModel save(ParkingSpotDTO parkingSpotDto) {
        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);

        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        return parkingSpotRepository.save(parkingSpotModel);
    }

    public ParkingSpotModel update(UUID id, ParkingSpotDTO parkingSpotDTO) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = findById(id);

        if (parkingSpotModelOptional.isPresent()) {
            ParkingSpotModel parkingSpotModel = parkingSpotModelOptional.get();
            parkingSpotModel.setParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber());
            parkingSpotModel.setLicensePlateCar(parkingSpotDTO.getLicensePlateCar());
            parkingSpotModel.setCarModel(parkingSpotDTO.getCarModel());
            parkingSpotModel.setCarColor(parkingSpotDTO.getCarColor());
            parkingSpotModel.setResponsibleName(parkingSpotDTO.getResponsibleName());
            parkingSpotModel.setApartment(parkingSpotDTO.getApartment());
            parkingSpotModel.setBlock(parkingSpotDTO.getBlock());

            Optional<CarBrandModel> carBrandModelOptional = carBrandService.findById(parkingSpotDTO.getCarBrandId());
            carBrandModelOptional.ifPresent(parkingSpotModel::setCarBrandId);

            return parkingSpotRepository.save(parkingSpotModel);
        }

        return null;
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

    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }

}
