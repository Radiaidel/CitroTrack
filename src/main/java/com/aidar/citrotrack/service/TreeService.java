package com.aidar.citrotrack.service;

import com.aidar.citrotrack.dto.Tree.TreeRequestDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;

import java.util.List;

public interface TreeService {
    TreeResponseDTO createTree(TreeRequestDTO treeRequestDTO);

    TreeResponseDTO updateTree(Long id, TreeRequestDTO treeRequestDTO);

    void deleteTree(Long id);

    TreeResponseDTO getTreeById(Long id);

    List<TreeResponseDTO> getAllTrees();
}
