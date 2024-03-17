package com.api.parking.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "car_brands")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @ToString
public class CarBrandModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    private Long brandId;

    @Column(nullable = false, unique = true)
    private String brandName;

    @OneToOne(mappedBy = "car_brands")
    private ParkingSpotModel parkingSpotModel;

}
