package com.api.parking.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarBrandDTO {

    @NotBlank
    private String brandName;

}
