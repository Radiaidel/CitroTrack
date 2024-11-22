package com.aidar.citrotrack.service.impl;

import com.aidar.citrotrack.dto.Customer.CustomerDTO;
import com.aidar.citrotrack.dto.Sale.SaleRequestDTO;
import com.aidar.citrotrack.dto.Sale.SaleResponseDTO;
import com.aidar.citrotrack.mapper.SaleMapper;
import com.aidar.citrotrack.model.Customer;
import com.aidar.citrotrack.model.Sale;
import com.aidar.citrotrack.repository.SaleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaleServiceImplTest {

//    @Mock
//    private SaleRepository saleRepository;
//
//    @Mock
//    private SaleMapper saleMapper;
//
//    @InjectMocks
//    private SaleServiceImpl saleService;
//
//    private Sale sale;
//    private SaleRequestDTO saleRequestDTO;
//    private SaleResponseDTO saleResponseDTO;
//
//    @BeforeEach
//    void setUp() {
//        sale = Sale.builder()
//                .id(1L)
//                .unitPrice(500.0)
//                .customer(Customer.builder().fullName("name").email("bla@gmail.com").build())
//                .dateSold(LocalDate.now())
//                .build();
//
//        saleRequestDTO = SaleRequestDTO.builder()
//                .unitPrice(500.0)
//                .customer(CustomerDTO.builder().fullName("name").email("bla@gmail.com").build())
//                .dateSold(LocalDate.now())
//                .build();
//
//        saleResponseDTO = SaleResponseDTO.builder()
//                .id(1L)
//                .unitPrice(500.0)
//                .customer(CustomerDTO.builder().fullName("name").email("bla@gmail.com").build())
//                .dateSold(LocalDate.now())
//                .build();
//    }
//
//    @Test
//    void createSale_success() {
//        when(saleMapper.saleRequestDTOToSale(any(SaleRequestDTO.class))).thenReturn(sale);
//        when(saleRepository.save(any(Sale.class))).thenReturn(sale);
//        when(saleMapper.saleToSaleResponseDTO(any(Sale.class))).thenReturn(saleResponseDTO);
//
//        SaleResponseDTO result = saleService.createSale(saleRequestDTO);
//
//        assertNotNull(result);
//        assertEquals(saleResponseDTO, result);
//        verify(saleMapper).saleRequestDTOToSale(saleRequestDTO);
//        verify(saleRepository).save(sale);
//        verify(saleMapper).saleToSaleResponseDTO(sale);
//    }
//
//    @Test
//    void getSaleById_success() {
//        when(saleRepository.findById(eq(1L))).thenReturn(Optional.of(sale));
//        when(saleMapper.saleToSaleResponseDTO(any(Sale.class))).thenReturn(saleResponseDTO);
//
//        SaleResponseDTO result = saleService.getSaleById(1L);
//
//        assertNotNull(result);
//        assertEquals(saleResponseDTO, result);
//        verify(saleRepository).findById(eq(1L));
//        verify(saleMapper).saleToSaleResponseDTO(sale);
//    }
//
//    @Test
//    void getSaleById_notFound_throwsException() {
//        when(saleRepository.findById(eq(1L))).thenReturn(Optional.empty());
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> saleService.getSaleById(1L));
//
//        assertEquals("Sale not found", exception.getMessage());
//        verify(saleRepository).findById(eq(1L));
//        verifyNoInteractions(saleMapper);
//    }
//
//    @Test
//    void getAllSales_success() {
//        when(saleRepository.findAll()).thenReturn(Arrays.asList(sale));
//        when(saleMapper.saleToSaleResponseDTO(any(Sale.class))).thenReturn(saleResponseDTO);
//
//        List<SaleResponseDTO> result = saleService.getAllSales();
//
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        assertEquals(saleResponseDTO, result.get(0));
//        verify(saleRepository).findAll();
//        verify(saleMapper).saleToSaleResponseDTO(sale);
//    }
//
//    @Test
//    void updateSale_success() {
//        when(saleRepository.findById(eq(1L))).thenReturn(Optional.of(sale));
//        when(saleMapper.saleRequestDTOToSale(any(SaleRequestDTO.class))).thenReturn(sale);
//        when(saleRepository.save(any(Sale.class))).thenReturn(sale);
//        when(saleMapper.saleToSaleResponseDTO(any(Sale.class))).thenReturn(saleResponseDTO);
//
//        SaleResponseDTO result = saleService.updateSale(1L, saleRequestDTO);
//
//        assertNotNull(result);
//        assertEquals(saleResponseDTO, result);
//        verify(saleRepository).findById(eq(1L));
//        verify(saleMapper).saleRequestDTOToSale(saleRequestDTO);
//        verify(saleRepository).save(sale);
//        verify(saleMapper).saleToSaleResponseDTO(sale);
//    }
//
//    @Test
//    void updateSale_notFound_throwsException() {
//        when(saleRepository.findById(eq(1L))).thenReturn(Optional.empty());
//
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> saleService.updateSale(1L, saleRequestDTO));
//
//        assertEquals("Sale not found", exception.getMessage());
//        verify(saleRepository).findById(eq(1L));
//        verifyNoInteractions(saleMapper);
//        verify(saleRepository, never()).save(any(Sale.class));
//    }
//
//    @Test
//    void deleteSale_success() {
//        doNothing().when(saleRepository).deleteById(eq(1L));
//
//        saleService.deleteSale(1L);
//
//        verify(saleRepository).deleteById(eq(1L));
//    }
}
