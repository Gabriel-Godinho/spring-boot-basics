package com.api.parking.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "parking_spots")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @ToString
public class ParkingSpotModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /*
     * UUID is a universally unique identifier used for identification of anything in the computing world.
     * The UUID is a 128-bit number represented by 32 hexadecimal digits, displayed in five groups separated by hyphens,
     * in textual form 8-4-4-4-12 totaling 36 characters (32 alphanumeric characters and 4 hyphens).
     *
     * Example: 3d0ca315-aff9-4fc2-be61-3b76b9a2d798
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_brand", referencedColumnName = "brand_id")
    private CarBrandModel carBrand;

    @Column(nullable = false, length = 70)
    private String carModel;

    @Column(nullable = false, length = 70)
    private String carColor;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false, length = 130)
    private String responsibleName;

    @Column(nullable = false, length = 30)
    private String apartment;

    @Column(nullable = false, length = 30)
    private String block;

}
