package com.aidar.citrotrack.controller;

import com.aidar.citrotrack.dto.Harvest.HarvestRequestDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestResponseDTO;
import com.aidar.citrotrack.service.HarvestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvests")
public class HarvestRestController {

    private final HarvestService harvestService;

    @Autowired
    public HarvestRestController(HarvestService harvestService) {
        this.harvestService = harvestService;
    }

    @PostMapping
    public ResponseEntity<HarvestResponseDTO> createHarvest(@Valid @RequestBody HarvestRequestDTO harvestRequestDTO) {
        HarvestResponseDTO createdHarvest = harvestService.createHarvest(harvestRequestDTO);
        return ResponseEntity.ok(createdHarvest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HarvestResponseDTO> updateHarvest(@PathVariable Long id, @Valid @RequestBody HarvestRequestDTO harvestRequestDTO) {
        HarvestResponseDTO updatedHarvest = harvestService.updateHarvest(id, harvestRequestDTO);
        return ResponseEntity.ok(updatedHarvest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHarvest(@PathVariable Long id) {
        harvestService.deleteHarvest(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<HarvestResponseDTO>> getAllHarvests() {
        return ResponseEntity.ok(harvestService.getAllHarvests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarvestResponseDTO> getHarvestById(@PathVariable Long id) {
        return ResponseEntity.ok(harvestService.getHarvestById(id));
    }
}
