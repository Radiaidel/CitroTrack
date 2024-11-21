package com.aidar.citrotrack.dto.Farm;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FarmRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Total area is required")
    @DecimalMin(value = "0.2", message = "Minimum area is 0.2 hectare")
    private Double totalArea;

    @PastOrPresent(message = "Creation date must be in the past or present")
    private LocalDate creationDate;

}
