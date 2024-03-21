package com.api.parking.controllers;

import com.api.parking.dtos.ParkingSpotDTO;
import com.api.parking.models.ParkingSpotModel;
import com.api.parking.services.CarBrandService;
import com.api.parking.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/car-brand")
public class CarBrandController {

    @Autowired
    CarBrandService carBrandService;

}