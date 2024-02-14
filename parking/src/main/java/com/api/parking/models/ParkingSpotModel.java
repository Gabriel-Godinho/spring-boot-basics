package com.api.parking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PARKING_SPOTS")
@Getter @NoArgsConstructor
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
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    @Setter private String parkingSpotNumber;

    @Column(nullable = false, unique = true, length = 7)
    @Setter private String licensePlateCar;

    @Column(nullable = false, length = 70)
    @Setter private String carBrand;

    @Column(nullable = false, length = 70)
    @Setter private String carModel;

    @Column(nullable = false, length = 70)
    @Setter private String carColor;

    @Column(nullable = false)
    @Setter private LocalDateTime registrationDate;

    @Column(nullable = false, length = 130)
    @Setter private String responsibleName;

    @Column(nullable = false, length = 30)
    @Setter private String apartment;

    @Column(nullable = false, length = 30)
    @Setter private String block;

}
