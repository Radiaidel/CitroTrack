package com.aidar.citrotrack.controller;


import com.aidar.citrotrack.dto.Field.FieldRequestDTO;
import com.aidar.citrotrack.dto.Field.FieldResponseDTO;
import com.aidar.citrotrack.service.FieldService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/fields")
public class FieldRestController {

    private final FieldService fieldService;


    @Autowired
    public FieldRestController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @PostMapping
    public ResponseEntity<FieldResponseDTO> createField(@Valid @RequestBody FieldRequestDTO fieldRequestDTO) {
        FieldResponseDTO createdfield = fieldService.createField(fieldRequestDTO);
        return ResponseEntity.ok(createdfield);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> updateField(@PathVariable Long id, @Valid @RequestBody FieldRequestDTO fieldRequestDTO) {
        FieldResponseDTO updatedfield = fieldService.updateField(id, fieldRequestDTO);
        return ResponseEntity.ok(updatedfield);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteField(@PathVariable Long id) {
        fieldService.deleteField(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FieldResponseDTO>> getAllFields() {
        return ResponseEntity.ok(fieldService.getAllFields());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> getFieldById(@PathVariable Long id) {
        return ResponseEntity.ok(fieldService.getFieldById(id));
    }
}
