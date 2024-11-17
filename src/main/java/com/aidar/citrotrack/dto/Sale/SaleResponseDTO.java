package com.aidar.citrotrack.dto.Sale;

import com.aidar.citrotrack.dto.Customer.CustomerDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestDTO;
import com.aidar.citrotrack.dto.Harvest.HarvestResponseDTO;
import com.aidar.citrotrack.model.Customer;
import com.aidar.citrotrack.model.Harvest;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponseDTO {

    private Long id;
    private double unitPrice;
    private double quantitySold;
    private LocalDate dateSold;
    private CustomerDTO customer;
    private HarvestDTO harvest;
}