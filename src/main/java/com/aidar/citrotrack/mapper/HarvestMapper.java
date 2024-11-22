package com.aidar.citrotrack.mapper;

import com.aidar.citrotrack.dto.Harvest.HarvestRequestDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestResponseDTO;
import com.aidar.citrotrack.model.Harvest;
import com.aidar.citrotrack.model.HarvestDetailId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HarvestMapper {

    Harvest toEntity(HarvestRequestDTO harvestRequestDTO);

    HarvestResponseDTO toResponse(Harvest harvest);

    default Long mapHarvestDetailId(HarvestDetailId harvestDetailId) {
        return harvestDetailId != null ? harvestDetailId.getHarvestId() : null;
    }
}
