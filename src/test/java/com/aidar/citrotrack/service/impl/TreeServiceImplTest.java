package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Field.FieldDTO;
import com.aidar.citrotrack.dto.Tree.TreeRequestDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;
import com.aidar.citrotrack.mapper.TreeMapper;
import com.aidar.citrotrack.model.Field;
import com.aidar.citrotrack.model.Tree;
import com.aidar.citrotrack.repository.FieldRepository;
import com.aidar.citrotrack.repository.TreeRepository;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TreeServiceImplTest {

    @Mock
    private TreeRepository treeRepository;

    @Mock
    private FieldRepository fieldRepository;

    @Mock
    private TreeMapper treeMapper;

    @InjectMocks
    private TreeServiceImpl treeService;

    private Tree tree;
    private Field field;
    private FieldDTO fieldDTO;
    private TreeRequestDTO treeRequestDTO;
    private TreeResponseDTO treeResponseDTO;

    @BeforeEach
    void setUp() {
        field = Field.builder()
                .id(1L)
                .area(100.0)
                .build();

        fieldDTO = FieldDTO.builder()
                .id(1L)
                .area(100.0)
                .build();

        tree = Tree.builder()
                .id(1L)
                .plantingDate(LocalDate.of(2023, 1, 1))
                .field(field)
                .build();

        treeRequestDTO = TreeRequestDTO.builder()
                .fieldId(1L)
                .plantingDate(LocalDate.of(2023, 2, 1))
                .build();

        treeResponseDTO = TreeResponseDTO.builder()
                .id(1L)
                .plantingDate(LocalDate.of(2023, 2, 1))
                .field(fieldDTO)
                .build();
    }

    @Test
    void testCreateTree() {
        when(fieldRepository.findById(1L)).thenReturn(Optional.of(field));
        when(treeRepository.save(any(Tree.class))).thenReturn(tree);
        when(treeMapper.treeToTreeResponseDTO(any(Tree.class))).thenReturn(treeResponseDTO);

        TreeResponseDTO result = treeService.createTree(treeRequestDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(fieldRepository).findById(1L);
        verify(treeRepository).save(any(Tree.class));
        verify(treeMapper).treeToTreeResponseDTO(any(Tree.class));
    }

    @Test
    void testGetTreeById() {
        when(treeRepository.findById(1L)).thenReturn(Optional.of(tree));
        when(treeMapper.treeToTreeResponseDTO(tree)).thenReturn(treeResponseDTO);

        TreeResponseDTO result = treeService.getTreeById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(treeRepository).findById(1L);
    }

    @Test
    void testGetTreeByIdNotFound() {
        when(treeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> treeService.getTreeById(1L));
        verify(treeRepository).findById(1L);
    }

    @Test
    void testGetAllTrees() {
        when(treeRepository.findAll()).thenReturn(Arrays.asList(tree));
        when(treeMapper.treeToTreeResponseDTO(tree)).thenReturn(treeResponseDTO);

        List<TreeResponseDTO> results = treeService.getAllTrees();

        assertNotNull(results);
        assertEquals(1, results.size());
        verify(treeRepository).findAll();
        verify(treeMapper).treeToTreeResponseDTO(tree);
    }

    @Test
    void testUpdateTree() {
        when(treeRepository.findById(1L)).thenReturn(Optional.of(tree));
        when(fieldRepository.findById(1L)).thenReturn(Optional.of(field));
        when(treeMapper.treeRequestDTOToTree(treeRequestDTO)).thenReturn(tree);
        when(treeRepository.save(tree)).thenReturn(tree);
        when(treeMapper.treeToTreeResponseDTO(tree)).thenReturn(treeResponseDTO);

        TreeResponseDTO result = treeService.updateTree(1L, treeRequestDTO);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(treeRepository).findById(1L);
        verify(fieldRepository).findById(1L);
        verify(treeRepository).save(tree);
        verify(treeMapper).treeToTreeResponseDTO(tree);
    }

    @Test
    void testUpdateTreeNotFound() {
        when(treeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> treeService.updateTree(1L, treeRequestDTO));
        verify(treeRepository).findById(1L);
    }

    @Test
    void testDeleteTree() {
        when(treeRepository.existsById(1L)).thenReturn(true);
        doNothing().when(treeRepository).deleteById(1L);

        treeService.deleteTree(1L);

        verify(treeRepository).existsById(1L);
        verify(treeRepository).deleteById(1L);
    }

    @Test
    void testDeleteTreeNotFound() {
        when(treeRepository.existsById(1L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> treeService.deleteTree(1L));
        verify(treeRepository).existsById(1L);
    }
}
