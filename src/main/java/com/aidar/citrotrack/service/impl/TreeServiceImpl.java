package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Tree.TreeRequestDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;
import com.aidar.citrotrack.model.Field;
import com.aidar.citrotrack.model.Tree;
import com.aidar.citrotrack.model.enums.TreeProductivity;
import com.aidar.citrotrack.repository.FieldRepository;
import com.aidar.citrotrack.repository.TreeRepository;
import com.aidar.citrotrack.service.TreeService;
import com.aidar.citrotrack.mapper.TreeMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeServiceImpl implements TreeService {

    private TreeRepository treeRepository;
    private TreeMapper treeMapper;

    private FieldRepository fieldRepository;

    public TreeServiceImpl(TreeRepository treeRepository, TreeMapper treeMapper , FieldRepository fieldRepository) {
        this.treeRepository = treeRepository;
        this.treeMapper = treeMapper;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public TreeResponseDTO createTree(TreeRequestDTO treeRequestDTO) {
        Field field = fieldRepository.findById(treeRequestDTO.getFieldId())
                .orElseThrow(() -> new RuntimeException("Field not found with ID: " + treeRequestDTO.getFieldId()));

        Tree tree = Tree.builder().plantingDate(treeRequestDTO.getPlantingDate()).field(field).build();
        treeRepository.save(tree);

        int age = TreeProductivity.calculateAge(tree.getPlantingDate());
        tree.setAge(age);
        tree.setProductivity(TreeProductivity.getProductivityByAge(age));
        tree.setHarvestDetails(new ArrayList<>());
        return treeMapper.toResponse(tree);
    }

    @Override
    public TreeResponseDTO updateTree(Long id, TreeRequestDTO treeRequestDTO) {

        treeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tree not found with ID: " + id));

        fieldRepository.findById(treeRequestDTO.getFieldId())
                .orElseThrow(() -> new RuntimeException("Field not found with ID: " + treeRequestDTO.getFieldId()));


        Tree tree = treeMapper.toEntity(treeRequestDTO);
        tree.setId(id);

        tree = treeRepository.save(tree);

        int age = TreeProductivity.calculateAge(tree.getPlantingDate());
        tree.setAge(age);
        tree.setProductivity(TreeProductivity.getProductivityByAge(age));
        tree.setHarvestDetails(new ArrayList<>());

        return treeMapper.toResponse(tree);
    }

    @Override
    public void deleteTree(Long id) {
        if (!treeRepository.existsById(id)) {
            throw new RuntimeException("Tree not found with ID: " + id);
        }
        treeRepository.deleteById(id);
    }

    @Override
    public TreeResponseDTO getTreeById(Long id) {

        Tree tree = treeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tree not found with ID: " + id));

        int age = TreeProductivity.calculateAge(tree.getPlantingDate());
        tree.setAge(age);
        tree.setProductivity(TreeProductivity.getProductivityByAge(age));
        tree.setHarvestDetails(new ArrayList<>());

        return treeMapper.toResponse(tree);
    }

    @Override
    public List<TreeResponseDTO> getAllTrees() {
        return treeRepository.findAll().stream()
                .peek(tree -> {
                    int age = TreeProductivity.calculateAge(tree.getPlantingDate());
                    tree.setAge(age);
                    tree.setProductivity(TreeProductivity.getProductivityByAge(age));
                    tree.setHarvestDetails(new ArrayList<>());
                })
                .map(treeMapper::toResponse)
                .collect(Collectors.toList());
    }
}
