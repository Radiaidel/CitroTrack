package com.aidar.citrotrack.mapper;

import com.aidar.citrotrack.dto.Farm.FarmDTO;
import com.aidar.citrotrack.dto.Field.FieldDTO;
import com.aidar.citrotrack.dto.Field.FieldRequestDTO;
import com.aidar.citrotrack.dto.Field.FieldResponseDTO;
import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.model.Field;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    FieldResponseDTO toResponse(Field field);

    @Mapping(source = "farmId", target = "farm.id")
    Field toEntity(FieldRequestDTO fieldRequestDTO);
}
