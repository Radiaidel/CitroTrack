package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Harvest.HarvestRequestDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestResponseDTO;
import com.aidar.citrotrack.mapper.HarvestMapper;
import com.aidar.citrotrack.model.Harvest;
import com.aidar.citrotrack.model.enums.Seasons;
import com.aidar.citrotrack.repository.HarvestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HarvestServiceImplTest {
//
//    @Mock
//    private HarvestRepository harvestRepository;
//
//    @Mock
//    private HarvestMapper harvestMapper;
//
//    @InjectMocks
//    private HarvestServiceImpl harvestService;
//
//    private Harvest harvest;
//    private HarvestRequestDTO harvestRequestDTO;
//    private HarvestResponseDTO harvestResponseDTO;
//
//    @BeforeEach
//    void setUp() {
//        harvest = Harvest.builder()
//                .id(1L)
//                .harvestDate(LocalDate.now())
//                .season(Seasons.SUMMER)
//                .build();
//
//        harvestRequestDTO = HarvestRequestDTO.builder()
//                .harvestDate(LocalDate.now())
//                .build();
//
//        harvestResponseDTO = HarvestResponseDTO.builder()
//                .id(1L)
//                .harvestDate(LocalDate.now())
//                .season(Seasons.SUMMER)
//                .build();
//    }
//
//    @Test
//    void createHarvest_success() {
//        when(harvestRepository.save(any(Harvest.class))).thenReturn(harvest);
//        when(harvestMapper.harvestToHarvestResponseDTO(any(Harvest.class))).thenReturn(harvestResponseDTO);
//
//        HarvestResponseDTO result = harvestService.createHarvest(harvestRequestDTO);
//
//        assertNotNull(result);
//        assertEquals(harvestResponseDTO, result);
//        verify(harvestRepository).save(any(Harvest.class));
//        verify(harvestMapper).harvestToHarvestResponseDTO(any(Harvest.class));
//    }
//
//
//    @Test
//    void deleteHarvest_success() {
//        when(harvestRepository.existsById(eq(1L))).thenReturn(true);
//
//        harvestService.deleteHarvest(1L);
//
//        verify(harvestRepository).existsById(eq(1L));
//        verify(harvestRepository).deleteById(eq(1L));
//    }
//
//    @Test
//    void deleteHarvest_notFound_throwsException() {
//        when(harvestRepository.existsById(eq(1L))).thenReturn(false);
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> harvestService.deleteHarvest(1L));
//
//        assertEquals("Harvest not found with ID: 1", exception.getMessage());
//        verify(harvestRepository).existsById(eq(1L));
//        verify(harvestRepository, never()).deleteById(eq(1L));
//    }
//
//    @Test
//    void getHarvestById_success() {
//        when(harvestRepository.findById(eq(1L))).thenReturn(Optional.of(harvest));
//        when(harvestMapper.harvestToHarvestResponseDTO(any(Harvest.class))).thenReturn(harvestResponseDTO);
//
//        HarvestResponseDTO result = harvestService.getHarvestById(1L);
//
//        assertNotNull(result);
//        assertEquals(harvestResponseDTO, result);
//        verify(harvestRepository).findById(eq(1L));
//        verify(harvestMapper).harvestToHarvestResponseDTO(any(Harvest.class));
//    }
//
//    @Test
//    void getHarvestById_notFound_throwsException() {
//        when(harvestRepository.findById(eq(1L))).thenReturn(Optional.empty());
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> harvestService.getHarvestById(1L));
//
//        assertEquals("Harvest not found with ID: 1", exception.getMessage());
//        verify(harvestRepository).findById(eq(1L));
//    }
//
//    @Test
//    void getAllHarvests_success() {
//        when(harvestRepository.findAll()).thenReturn(Arrays.asList(harvest));
//        when(harvestMapper.harvestToHarvestResponseDTO(any(Harvest.class))).thenReturn(harvestResponseDTO);
//
//        List<HarvestResponseDTO> result = harvestService.getAllHarvests();
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals(harvestResponseDTO, result.get(0));
//        verify(harvestRepository).findAll();
//        verify(harvestMapper).harvestToHarvestResponseDTO(any(Harvest.class));
//    }
}
