package com.aidar.citrotrack.controller;

import com.aidar.citrotrack.dto.Farm.FarmRequestDTO;
import com.aidar.citrotrack.dto.Farm.FarmResponseDTO;
import com.aidar.citrotrack.model.Farm;
import com.aidar.citrotrack.service.FarmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/farms")
public class FarmRestController {

    private final FarmService farmService;


    @Autowired
    public FarmRestController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping
    public ResponseEntity<FarmResponseDTO> createFarm(@Valid @RequestBody  FarmRequestDTO farmRequestDTO){
        FarmResponseDTO createdfarm = farmService.createFarm(farmRequestDTO);
        return ResponseEntity.ok(createdfarm);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FarmResponseDTO> updateFarm(@PathVariable Long id ,@Valid @RequestBody FarmRequestDTO farmRequestDTO){
        FarmResponseDTO updatedfarm = farmService.updateFarm(id , farmRequestDTO);
        return ResponseEntity.ok(updatedfarm);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarm(@PathVariable Long id ){
        farmService.deleteFarm(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<FarmResponseDTO>> getAllFarms(){
        return ResponseEntity.ok(farmService.getAllFarms());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FarmResponseDTO> getFarmById(@PathVariable Long id){
        return ResponseEntity.ok(farmService.getFarmById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<FarmResponseDTO>> searchFarms(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double minArea,
            @RequestParam(required = false) Double maxArea,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDateFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDateTo) {

        List<FarmResponseDTO> farms = farmService.searchFarms(name, location, minArea, maxArea, creationDateFrom, creationDateTo);
        return ResponseEntity.ok(farms);
    }
}
