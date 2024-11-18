package com.aidar.citrotrack.dto.Harvest;

import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailRequestDTO;
import com.aidar.citrotrack.model.enums.Seasons;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HarvestRequestDTO {

    @NotNull(message = "Harvest date is required")
    @PastOrPresent(message = "Harvest date must be in the past or present")
    private LocalDate harvestDate;
}