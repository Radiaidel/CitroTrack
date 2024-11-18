package com.aidar.citrotrack.controller;


import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailRequestDTO;
import com.aidar.citrotrack.dto.HarvestDetail.HarvestDetailResponseDTO;
import com.aidar.citrotrack.service.HarvestDetailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvest-details")
public class HarvestDetailRestController {

    private final HarvestDetailService harvestDetailService;

    @Autowired
    public HarvestDetailRestController(HarvestDetailService harvestDetailService) {
        this.harvestDetailService = harvestDetailService;
    }

    @PostMapping
    public ResponseEntity<HarvestDetailResponseDTO> createHarvestDetail(
            @Valid @RequestBody HarvestDetailRequestDTO harvestDetailRequestDTO) {
        return new ResponseEntity<>(
                harvestDetailService.createHarvestDetail(harvestDetailRequestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{harvestId}/{treeId}")
    public ResponseEntity<HarvestDetailResponseDTO> getHarvestDetail(
            @PathVariable Long harvestId,
            @PathVariable Long treeId) {
        return ResponseEntity.ok(
                harvestDetailService.getHarvestDetail(harvestId, treeId)
        );
    }

    @GetMapping("/harvest/{harvestId}")
    public ResponseEntity<List<HarvestDetailResponseDTO>> getHarvestDetailsByHarvest(
            @PathVariable Long harvestId) {
        return ResponseEntity.ok(
                harvestDetailService.getHarvestDetailsByHarvest(harvestId)
        );
    }

    @PutMapping("/{harvestId}/{treeId}")
    public ResponseEntity<HarvestDetailResponseDTO> updateHarvestDetail(
            @PathVariable Long harvestId,
            @PathVariable Long treeId,
            @Valid @RequestBody HarvestDetailRequestDTO harvestDetailRequestDTO) {
        return ResponseEntity.ok(
                harvestDetailService.updateHarvestDetail(harvestId, treeId, harvestDetailRequestDTO)
        );
    }

    @DeleteMapping("/{harvestId}/{treeId}")
    public ResponseEntity<Void> deleteHarvestDetail(
            @PathVariable Long harvestId,
            @PathVariable Long treeId) {
        harvestDetailService.deleteHarvestDetail(harvestId, treeId);
        return ResponseEntity.noContent().build();
    }
}