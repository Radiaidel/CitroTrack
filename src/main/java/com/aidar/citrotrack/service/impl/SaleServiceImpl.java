package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Sale.SaleRequestDTO;
import com.aidar.citrotrack.dto.Sale.SaleResponseDTO;
import com.aidar.citrotrack.model.Sale;
import com.aidar.citrotrack.repository.SaleRepository;
import com.aidar.citrotrack.service.SaleService;
import com.aidar.citrotrack.mapper.SaleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    public SaleServiceImpl(SaleRepository saleRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    @Override
    public SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO) {
        Sale sale = saleMapper.saleRequestDTOToSale(saleRequestDTO);
        Sale savedSale = saleRepository.save(sale);
        return saleMapper.saleToSaleResponseDTO(savedSale);
    }

    @Override
    public SaleResponseDTO getSaleById(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        return saleMapper.saleToSaleResponseDTO(sale);
    }

    @Override
    public List<SaleResponseDTO> getAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream()
                .map(saleMapper::saleToSaleResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SaleResponseDTO updateSale(Long id, SaleRequestDTO saleRequestDTO) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        sale = saleMapper.saleRequestDTOToSale(saleRequestDTO);
        Sale updatedSale = saleRepository.save(sale);
        return saleMapper.saleToSaleResponseDTO(updatedSale);
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
