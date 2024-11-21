package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailRequestDTO;
import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailResponseDTO;
import com.aidar.citrotrack.mapper.HarvestDetailMapper;
import com.aidar.citrotrack.model.Harvest;
import com.aidar.citrotrack.model.HarvestDetail;
import com.aidar.citrotrack.model.HarvestDetailId;
import com.aidar.citrotrack.model.Tree;
import com.aidar.citrotrack.repository.HarvestDetailRepository;
import com.aidar.citrotrack.repository.HarvestRepository;
import com.aidar.citrotrack.repository.TreeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HarvestDetailServiceImplTest {

    @Mock
    private HarvestDetailRepository harvestDetailRepository;

    @Mock
    private HarvestRepository harvestRepository;

    @Mock
    private TreeRepository treeRepository;

    @Mock
    private HarvestDetailMapper harvestDetailMapper;

    @InjectMocks
    private HarvestDetailServiceImpl harvestDetailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateHarvestDetail_Success() {
        HarvestDetailRequestDTO requestDTO = new HarvestDetailRequestDTO(10.0, 1L, 2L);
        Harvest harvest =  Harvest.builder().build();
        Tree tree =  Tree.builder().build();
        HarvestDetail harvestDetail =  HarvestDetail.builder().build();
        HarvestDetailId id = new HarvestDetailId(1L, 2L);

        when(harvestRepository.findById(1L)).thenReturn(Optional.of(harvest));
        when(treeRepository.findById(2L)).thenReturn(Optional.of(tree));
        when(harvestDetailRepository.existsById(id)).thenReturn(false);
        when(harvestDetailMapper.harvestDetailRequestDTOToHarvestDetail(requestDTO)).thenReturn(harvestDetail);
        when(harvestDetailRepository.save(harvestDetail)).thenReturn(harvestDetail);
        HarvestDetailResponseDTO responseDTO = new HarvestDetailResponseDTO(id, 10.0, null, null);
        when(harvestDetailMapper.harvestDetailToHarvestDetailResponseDTO(harvestDetail)).thenReturn(responseDTO);

        HarvestDetailResponseDTO result = harvestDetailService.createHarvestDetail(requestDTO);

        assertNotNull(result);
        assertEquals(10.0, result.quantity());
        verify(harvestRepository, times(1)).findById(1L);
        verify(treeRepository, times(1)).findById(2L);
        verify(harvestDetailRepository, times(1)).save(harvestDetail);
    }

    @Test
    void testCreateHarvestDetail_HarvestNotFound() {
        HarvestDetailRequestDTO requestDTO = new HarvestDetailRequestDTO(10.0, 1L, 2L);
        when(harvestRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> harvestDetailService.createHarvestDetail(requestDTO));
        assertEquals("Harvest not found", exception.getMessage());
        verify(harvestRepository, times(1)).findById(1L);
        verifyNoInteractions(treeRepository, harvestDetailRepository);
    }

    @Test
    void testGetHarvestDetail_Success() {
        HarvestDetailId id = new HarvestDetailId(1L, 2L);
        HarvestDetail harvestDetail = new HarvestDetail();
        HarvestDetailResponseDTO responseDTO = new HarvestDetailResponseDTO(id, 10.0, null, null);

        when(harvestDetailRepository.findById(id)).thenReturn(Optional.of(harvestDetail));
        when(harvestDetailMapper.harvestDetailToHarvestDetailResponseDTO(harvestDetail)).thenReturn(responseDTO);

        HarvestDetailResponseDTO result = harvestDetailService.getHarvestDetail(1L, 2L);

        assertNotNull(result);
        assertEquals(10.0, result.quantity());
        verify(harvestDetailRepository, times(1)).findById(id);
    }

    @Test
    void testGetHarvestDetail_NotFound() {
        HarvestDetailId id = new HarvestDetailId(1L, 2L);
        when(harvestDetailRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> harvestDetailService.getHarvestDetail(1L, 2L));
        assertEquals("Harvest detail not found", exception.getMessage());
        verify(harvestDetailRepository, times(1)).findById(id);
    }

    @Test
    void testDeleteHarvestDetail_Success() {
        HarvestDetailId id = new HarvestDetailId(1L, 2L);
        when(harvestDetailRepository.existsById(id)).thenReturn(true);

        assertDoesNotThrow(() -> harvestDetailService.deleteHarvestDetail(1L, 2L));

        verify(harvestDetailRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteHarvestDetail_NotFound() {
        HarvestDetailId id = new HarvestDetailId(1L, 2L);
        when(harvestDetailRepository.existsById(id)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> harvestDetailService.deleteHarvestDetail(1L, 2L));
        assertEquals("Harvest detail not found", exception.getMessage());
        verify(harvestDetailRepository, never()).deleteById(id);
    }
}
