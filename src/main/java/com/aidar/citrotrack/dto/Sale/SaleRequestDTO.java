package com.aidar.citrotrack.dto.Sale;

import com.aidar.citrotrack.dto.Customer.CustomerDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequestDTO {

    @Positive(message = "Unit price must be positive")
    private double unitPrice;

    @Positive(message = "Quantity sold must be zero or positive")
    private double quantitySold;

    @NotNull(message = "Date sold cannot be null")
    @PastOrPresent(message = "Date sold must be in the past or present")
    private LocalDate dateSold;

    private CustomerDTO customer;

    private Long harvestId;
}