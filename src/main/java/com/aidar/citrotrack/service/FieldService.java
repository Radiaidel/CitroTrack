package com.aidar.citrotrack.service;

import com.aidar.citrotrack.dto.Field.FieldDTO;
import com.aidar.citrotrack.dto.Field.FieldRequestDTO;
import com.aidar.citrotrack.dto.Field.FieldResponseDTO;

import java.util.List;

public interface FieldService {
    FieldDTO createField(FieldRequestDTO fieldRequestDTO);

    List<FieldResponseDTO> getAllFields();

    FieldResponseDTO getFieldById(Long id);

    FieldDTO updateField(Long id, FieldRequestDTO fieldRequestDTO);

    void deleteField(Long id);
}
