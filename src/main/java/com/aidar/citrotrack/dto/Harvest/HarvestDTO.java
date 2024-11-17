package com.aidar.citrotrack.dto.Harvest;

import com.aidar.citrotrack.model.enums.Seasons;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDTO {

    private Long id;
    private LocalDate harvestDate;
    private Seasons season;
    private double totalQuantity;
}
