package com.api.parking.repositories;

import com.api.parking.models.CarBrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrandModel, Long> {
}
