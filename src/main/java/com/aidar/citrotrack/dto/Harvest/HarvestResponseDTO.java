package com.aidar.citrotrack.dto.Harvest;

import com.aidar.citrotrack.dto.HarvestDetail.EmbeddableHarvestDetailDTO;
import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailResponseDTO;
import com.aidar.citrotrack.model.enums.Seasons;
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
public class HarvestResponseDTO {

    private Long id;
    private LocalDate harvestDate;
    private Seasons season;
    private double totalQuantity;
    private List<EmbeddableHarvestDetailDTO> harvestDetails;
}