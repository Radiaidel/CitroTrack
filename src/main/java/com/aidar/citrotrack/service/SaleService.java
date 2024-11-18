package com.aidar.citrotrack.service;

import com.aidar.citrotrack.dto.Sale.SaleRequestDTO;
import com.aidar.citrotrack.dto.Sale.SaleResponseDTO;

import java.util.List;

public interface SaleService {
    SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO);
    SaleResponseDTO getSaleById(Long id);
    List<SaleResponseDTO> getAllSales();
    SaleResponseDTO updateSale(Long id, SaleRequestDTO saleRequestDTO);
    void deleteSale(Long id);
}
