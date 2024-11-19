package com.aidar.citrotrack.controller;


import com.aidar.citrotrack.dto.Sale.SaleRequestDTO;
import com.aidar.citrotrack.dto.Sale.SaleResponseDTO;
import com.aidar.citrotrack.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleRestController {

    private final SaleService saleService;

    @Autowired
    public SaleRestController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleResponseDTO> createSale(@Valid @RequestBody SaleRequestDTO saleRequestDTO) {
        SaleResponseDTO saleResponseDTO = saleService.createSale(saleRequestDTO);
        return new ResponseEntity<>(saleResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> getSaleById(@PathVariable Long id) {
        SaleResponseDTO saleResponseDTO = saleService.getSaleById(id);
        return new ResponseEntity<>(saleResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getAllSales() {
        List<SaleResponseDTO> salesResponseDTO = saleService.getAllSales();
        return new ResponseEntity<>(salesResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> updateSale(@PathVariable Long id, @Valid @RequestBody SaleRequestDTO saleRequestDTO) {
        SaleResponseDTO saleResponseDTO = saleService.updateSale(id, saleRequestDTO);
        return new ResponseEntity<>(saleResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
