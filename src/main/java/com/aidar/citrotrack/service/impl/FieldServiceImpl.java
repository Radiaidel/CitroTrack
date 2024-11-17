package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Field.FieldRequestDTO;
import com.aidar.citrotrack.dto.Field.FieldResponseDTO;
import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.model.Field;
import com.aidar.citrotrack.repository.FarmRepository;
import com.aidar.citrotrack.repository.FieldRepository;
import com.aidar.citrotrack.service.FieldService;
import com.aidar.citrotrack.util.FieldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldServiceImpl implements FieldService {
    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;

    private final FarmRepository farmRepository;
    @Autowired
    public FieldServiceImpl(FieldRepository fieldRepository, FarmRepository farmRepository, FieldMapper fieldMapper) {
        this.fieldRepository = fieldRepository;
        this.farmRepository = farmRepository;
        this.fieldMapper = fieldMapper;
    }

    @Override
    public FieldResponseDTO createField(FieldRequestDTO fieldRequestDTO) {
        Farm farm = farmRepository.findById(fieldRequestDTO.getFarmId())
                .orElseThrow(() -> new RuntimeException("Farm not found with ID: " + fieldRequestDTO.getFarmId()));

        Field field = Field.builder()
                .area(fieldRequestDTO.getArea())
                .farm(farm)
                .build();

        field = fieldRepository.save(field);

        return fieldMapper.fieldToFieldResponseDTO(field);
    }

    @Override
    public List<FieldResponseDTO> getAllFields() {
        return fieldRepository.findAll()
                .stream()
                .map(fieldMapper::fieldToFieldResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FieldResponseDTO getFieldById(Long id) {
        Field field = fieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found with ID: " + id));
        return fieldMapper.fieldToFieldResponseDTO(field);
    }

    @Override
    public FieldResponseDTO updateField(Long id, FieldRequestDTO fieldRequestDTO) {
        Field field = fieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found with ID: " + id));

        Farm farm = farmRepository.findById(fieldRequestDTO.getFarmId())
                .orElseThrow(() -> new RuntimeException("Farm not found with ID: " + fieldRequestDTO.getFarmId()));



        field = fieldMapper.fieldRequestDTOToField(fieldRequestDTO);
        field.setId(id);

        field = fieldRepository.save(field);


        return fieldMapper.fieldToFieldResponseDTO(field);
    }

    @Override
    public void deleteField(Long id) {
        if (!fieldRepository.existsById(id)) {
            throw new RuntimeException("Field not found with ID: " + id);
        }
        fieldRepository.deleteById(id);
    }
}
