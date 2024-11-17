package com.aidar.citrotrack.controller;

import com.aidar.citrotrack.dto.Tree.TreeRequestDTO;
import com.aidar.citrotrack.dto.Tree.TreeResponseDTO;
import com.aidar.citrotrack.service.TreeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class TreeRestController {

    private TreeService treeService;

    @Autowired
    public TreeRestController(TreeService treeService) {
        this.treeService = treeService;
    }

    @PostMapping
    public ResponseEntity<TreeResponseDTO> createTree(@Valid @RequestBody TreeRequestDTO treeRequestDTO){
        return ResponseEntity.ok(treeService.createTree(treeRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreeResponseDTO> updateTree(@PathVariable Long id , @Valid @RequestBody TreeRequestDTO treeRequestDTO){
        return ResponseEntity.ok(treeService.updateTree(id , treeRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTree(@PathVariable Long id ){
        treeService.deleteTree(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeResponseDTO> getTreeById(@PathVariable Long id){
        return ResponseEntity.ok(treeService.getTreeById(id));
    }

    @GetMapping
    public ResponseEntity<List<TreeResponseDTO>> getAllTrees(){
        return ResponseEntity.ok(treeService.getAllTrees());
    }

}
