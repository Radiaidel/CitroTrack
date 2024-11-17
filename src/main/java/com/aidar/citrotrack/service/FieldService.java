package com.aidar.citrotrack.service;

import com.aidar.citrotrack.dto.Field.FieldRequestDTO;
import com.aidar.citrotrack.dto.Field.FieldResponseDTO;

import java.util.List;

public interface FieldService {
    FieldResponseDTO createField(FieldRequestDTO fieldRequestDTO);

    List<FieldResponseDTO> getAllFields();

    FieldResponseDTO getFieldById(Long id);

    FieldResponseDTO updateField(Long id, FieldRequestDTO fieldRequestDTO);

    void deleteField(Long id);
}
