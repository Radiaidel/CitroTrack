package com.aidar.citrotrack.mapper;

import com.aidar.citrotrack.dto.Field.FieldRequestDTO;
import com.aidar.citrotrack.dto.Field.FieldResponseDTO;
import com.aidar.citrotrack.model.Field;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    FieldResponseDTO fieldToFieldResponseDTO(Field field);

    @Mapping(source = "farmId", target = "farm.id")
    Field fieldRequestDTOToField(FieldRequestDTO fieldRequestDTO);
}
