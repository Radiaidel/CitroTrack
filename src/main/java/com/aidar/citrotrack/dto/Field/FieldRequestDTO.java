package com.aidar.citrotrack.dto.Field;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldRequestDTO {

    @NotNull(message = "Area is required")
    @DecimalMin(value = "0.1", message = "Minimum area is 0.1 hectare")
    private Double area;

    @NotNull(message = "Farm ID is required")
    private Long farmId;
}