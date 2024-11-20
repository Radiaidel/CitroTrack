package com.aidar.citrotrack.mapper;

import com.aidar.citrotrack.dto.Farm.FarmDTO;
import com.aidar.citrotrack.dto.Farm.FarmRequestDTO;
import com.aidar.citrotrack.dto.Farm.FarmResponseDTO;
import com.aidar.citrotrack.model.Farm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    FarmResponseDTO farmToFarmResponseDTO(Farm farm);

    Farm farmRequestDTOToFarm(FarmRequestDTO farmRequestDTO);

    FarmDTO farmToFarmDTO(Farm farm);

    @Mapping(target = "fields", ignore = true)
    void updateFarmFromDTO(FarmRequestDTO farmRequestDTO, @MappingTarget Farm farm);
}
