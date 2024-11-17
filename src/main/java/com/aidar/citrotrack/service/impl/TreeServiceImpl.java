package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Tree.TreeRequestDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;
import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.model.Field;
import com.aidar.citrotrack.model.Tree;
import com.aidar.citrotrack.repository.FieldRepository;
import com.aidar.citrotrack.repository.TreeRepository;
import com.aidar.citrotrack.service.TreeService;
import com.aidar.citrotrack.util.TreeMapper;
import org.springframework.stereotype.Service;

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
        return treeMapper.treeToTreeResponseDTO(tree);
    }

    @Override
    public TreeResponseDTO updateTree(Long id, TreeRequestDTO treeRequestDTO) {

        Tree tree = treeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tree not found with ID: " + id));

        Field field = fieldRepository.findById(treeRequestDTO.getFieldId())
                .orElseThrow(() -> new RuntimeException("Field not found with ID: " + treeRequestDTO.getFieldId()));



        tree = treeMapper.treeRequestDTOToTree(treeRequestDTO);
        tree.setId(id);

        tree = treeRepository.save(tree);


        return treeMapper.treeToTreeResponseDTO(tree);
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
        return treeMapper.treeToTreeResponseDTO(tree);
    }

    @Override
    public List<TreeResponseDTO> getAllTrees() {

        return treeRepository.findAll().stream().map(treeMapper::treeToTreeResponseDTO).collect(Collectors.toList());

    }
}
