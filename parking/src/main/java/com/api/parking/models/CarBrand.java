package com.api.parking.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car_brands")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @ToString
public class CarBrand implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long brandId;

    @Column(nullable = false, unique = true)
    private String brandName;

    @OneToMany(mappedBy = "carBrandId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ParkingSpot> carBrandModels = new HashSet<>();

}
