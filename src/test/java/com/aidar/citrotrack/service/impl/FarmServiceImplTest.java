package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Farm.FarmDTO;
import com.aidar.citrotrack.dto.Farm.FarmRequestDTO;
import com.aidar.citrotrack.dto.Farm.FarmResponseDTO;
import com.aidar.citrotrack.mapper.FarmMapper;
import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.repository.FarmRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("qa")
public class FarmServiceImplTest {
//
//    @Mock
//    private FarmRepository farmRepository;
//
//    @Mock
//    private FarmMapper farmMapper;
//
//    @InjectMocks
//    private FarmServiceImpl farmService;
//
//    private Farm farm;
//    private FarmRequestDTO farmRequestDTO;
//    private FarmResponseDTO farmResponseDTO;
//
//    @BeforeEach
//    void setUp() {
//        farm = Farm.builder()
//                .id(1L)
//                .name("Test Farm")
//                .location("Test Location")
//                .totalArea(100.0)
//                .creationDate(LocalDate.of(2023, 1, 1))
//                .build();
//
//        farmRequestDTO = FarmRequestDTO.builder()
//                .name("Updated Farm")
//                .location("Updated Location")
//                .totalArea(200.0)
//                .creationDate(LocalDate.of(2023, 2, 1)).build();
//
//        farmResponseDTO =  FarmResponseDTO.builder()
//                .id(1L)
//                .name("Updated Farm")
//                .location("Updated Location")
//                .totalArea(200.0)
//                .creationDate(LocalDate.of(2023, 2, 1)).build();
//    }
//
//    @Test
//    void testCreateFarm() {
//        when(farmRepository.save(any(Farm.class))).thenReturn(farm);
//        when(farmMapper.farmToFarmDTO(any(Farm.class))).thenReturn(new FarmDTO());
//
//        FarmDTO result = farmService.createFarm(farmRequestDTO);
//
//        assertNotNull(result);
//        verify(farmRepository).save(any(Farm.class));
//        verify(farmMapper).farmToFarmDTO(any(Farm.class));
//    }
//
//    @Test
//    void testGetAllFarms() {
//        List<Farm> farms = Arrays.asList(farm);
//        when(farmRepository.findAll()).thenReturn(farms);
//        when(farmMapper.farmToFarmResponseDTO(any(Farm.class))).thenReturn(farmResponseDTO);
//
//        List<FarmResponseDTO> results = farmService.getAllFarms();
//
//        assertNotNull(results);
//        assertEquals(1, results.size());
//        verify(farmRepository).findAll();
//        verify(farmMapper, times(1)).farmToFarmResponseDTO(any(Farm.class));
//    }
//
//    @Test
//    void testGetFarmById() {
//        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
//        when(farmMapper.farmToFarmResponseDTO(farm)).thenReturn(farmResponseDTO);
//
//        FarmResponseDTO result = farmService.getFarmById(1L);
//
//        assertNotNull(result);
//        assertEquals(1L, result.getId());
//        verify(farmRepository).findById(1L);
//    }
//
//    @Test
//    void testGetFarmByIdNotFound() {
//        when(farmRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> {
//            farmService.getFarmById(1L);
//        });
//    }
//
//    @Test
//    void testUpdateFarm() {
//        when(farmRepository.findById(1L)).thenReturn(Optional.of(farm));
//        doNothing().when(farmMapper).updateFarmFromDTO(farmRequestDTO, farm);
//        when(farmRepository.save(farm)).thenReturn(farm);
//        when(farmMapper.farmToFarmResponseDTO(farm)).thenReturn(farmResponseDTO);
//
//        FarmDTO result = farmService.updateFarm(1L, farmRequestDTO);
//
//        assertNotNull(result);
//        assertEquals("Updated Farm", result.getName());
//        verify(farmRepository).findById(1L);
//        verify(farmRepository).save(farm);
//    }
//
//    @Test
//    void testDeleteFarm() {
//        when(farmRepository.existsById(1L)).thenReturn(true);
//        doNothing().when(farmRepository).deleteById(1L);
//
//        farmService.deleteFarm(1L);
//
//        verify(farmRepository).existsById(1L);
//        verify(farmRepository).deleteById(1L);
//    }
//
//    @Test
//    void testDeleteFarmNotFound() {
//        when(farmRepository.existsById(1L)).thenReturn(false);
//
//        assertThrows(RuntimeException.class, () -> {
//            farmService.deleteFarm(1L);
//        });
//    }
//
//    @Test
//    void testSearchFarms() {
//        Map<String, Object> criteria = new HashMap<>();
//        criteria.put("name", "Test Farm");
//
//        criteria.put("location", "Test Location");
//
//        List<Farm> farms = Arrays.asList(farm);
//        when(farmRepository.searchFarms(criteria)).thenReturn(farms);
//        when(farmMapper.farmToFarmResponseDTO(farm)).thenReturn(farmResponseDTO);
//
//        List<FarmResponseDTO> results = farmService.searchFarms(
//                "Test Farm", "Test Location", null, null, null, null
//        );
//
//        assertNotNull(results);
//        assertEquals(1, results.size());
//        verify(farmRepository).searchFarms(any(Map.class));
//    }
}