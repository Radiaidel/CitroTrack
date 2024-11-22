package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Farm.FarmDTO;
import com.aidar.citrotrack.dto.Field.FieldDTO;
import com.aidar.citrotrack.dto.Field.FieldRequestDTO;
import com.aidar.citrotrack.dto.Field.FieldResponseDTO;
import com.aidar.citrotrack.mapper.FieldMapper;
import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.model.Field;
import com.aidar.citrotrack.repository.FarmRepository;
import com.aidar.citrotrack.repository.FieldRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("qa")
public class FieldServiceImplTest {

//    @Mock
//    private FieldRepository fieldRepository;
//
//    @Mock
//    private FarmRepository farmRepository;
//
//    @Mock
//    private FieldMapper fieldMapper;
//
//    @InjectMocks
//    private FieldServiceImpl fieldService;
//
//    private Field field;
//    private Farm farm;
//    private FarmDTO farmDTO;
//    private FieldRequestDTO fieldRequestDTO;
//    private FieldResponseDTO fieldResponseDTO;
//
//    @BeforeEach
//    void setUp() {
//        farm = Farm.builder()
//                .id(1L)
//                .name("Test Farm")
//                .location("Test Location")
//                .build();
//
//        farmDTO = FarmDTO.builder()
//                .id(1L)
//                .name("Test Farm")
//                .location("Test Location")
//                .build();
//
//        field = Field.builder()
//                .id(1L)
//                .area(50.0)
//                .farm(farm)
//                .build();
//
//        fieldRequestDTO = FieldRequestDTO.builder()
//                .area(100.0)
//                .farmId(1L)
//                .build();
//
//        fieldResponseDTO = FieldResponseDTO.builder()
//                .id(1L)
//                .area(100.0)
//                .farm(farmDTO)
//                .build();
//    }
//
//    @Test
//    void testCreateField() {
//        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
//        when(fieldRepository.save(any(Field.class))).thenReturn(field);
//        when(fieldMapper.fieldToFieldResponseDTO(field)).thenReturn(fieldResponseDTO);
//
//        FieldDTO result = fieldService.createField(fieldRequestDTO);
//
//        assertNotNull(result);
//        assertEquals(1L, result.getId());
//        verify(farmRepository).findById(1L);
//        verify(fieldRepository).save(any(Field.class));
//        verify(fieldMapper).fieldToFieldResponseDTO(field);
//    }
//
//    @Test
//    void testCreateFieldFarmNotFound() {
//        when(farmRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> fieldService.createField(fieldRequestDTO));
//        verify(farmRepository).findById(1L);
//        verify(fieldRepository, never()).save(any(Field.class));
//    }
//
//    @Test
//    void testGetAllFields() {
//        List<Field> fields = Arrays.asList(field);
//        when(fieldRepository.findAll()).thenReturn(fields);
//        when(fieldMapper.fieldToFieldResponseDTO(field)).thenReturn(fieldResponseDTO);
//
//        List<FieldResponseDTO> results = fieldService.getAllFields();
//
//        assertNotNull(results);
//        assertEquals(1, results.size());
//        verify(fieldRepository).findAll();
//        verify(fieldMapper).fieldToFieldResponseDTO(field);
//    }
//
//    @Test
//    void testGetFieldById() {
//        when(fieldRepository.findById(1L)).thenReturn(Optional.of(field));
//        when(fieldMapper.fieldToFieldResponseDTO(field)).thenReturn(fieldResponseDTO);
//
//        FieldResponseDTO result = fieldService.getFieldById(1L);
//
//        assertNotNull(result);
//        assertEquals(1L, result.getId());
//        verify(fieldRepository).findById(1L);
//    }
//
//    @Test
//    void testGetFieldByIdNotFound() {
//        when(fieldRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> fieldService.getFieldById(1L));
//        verify(fieldRepository).findById(1L);
//    }
//
//    @Test
//    void testUpdateField() {
//        when(fieldRepository.findById(1L)).thenReturn(Optional.of(field));
//        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
//        when(fieldMapper.fieldRequestDTOToField(fieldRequestDTO)).thenReturn(field);
//        when(fieldRepository.save(field)).thenReturn(field);
//        when(fieldMapper.fieldToFieldResponseDTO(field)).thenReturn(fieldResponseDTO);
//
//        FieldDTO result = fieldService.updateField(1L, fieldRequestDTO);
//
//        assertNotNull(result);
//        assertEquals(1L, result.getId());
//        verify(fieldRepository).findById(1L);
//        verify(fieldRepository).save(field);
//    }
//
//    @Test
//    void testUpdateFieldNotFound() {
//        when(fieldRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> fieldService.updateField(1L, fieldRequestDTO));
//        verify(fieldRepository).findById(1L);
//        verify(fieldRepository, never()).save(any(Field.class));
//    }
//
//    @Test
//    void testDeleteField() {
//        when(fieldRepository.existsById(1L)).thenReturn(true);
//        doNothing().when(fieldRepository).deleteById(1L);
//
//        fieldService.deleteField(1L);
//
//        verify(fieldRepository).existsById(1L);
//        verify(fieldRepository).deleteById(1L);
//    }
//
//    @Test
//    void testDeleteFieldNotFound() {
//        when(fieldRepository.existsById(1L)).thenReturn(false);
//
//        assertThrows(RuntimeException.class, () -> fieldService.deleteField(1L));
//        verify(fieldRepository).existsById(1L);
//        verify(fieldRepository, never()).deleteById(anyLong());
//    }
}
