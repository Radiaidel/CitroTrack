package com.aidar.citrotrack.util;

import com.aidar.citrotrack.dto.Farm.FarmRequestDTO;
import com.aidar.citrotrack.dto.Farm.FarmResponseDTO;
import com.aidar.citrotrack.model.Farm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FarmMapper {

    FarmResponseDTO farmToFarmResponseDTO(Farm farm);

    Farm farmRequestDTOToFarm(FarmRequestDTO farmRequestDTO);
}
