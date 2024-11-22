package com.aidar.citrotrack.mapper;


import com.aidar.citrotrack.dto.Sale.SaleRequestDTO;
import com.aidar.citrotrack.dto.Sale.SaleResponseDTO;
import com.aidar.citrotrack.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(source = "customer.fullName", target = "customer.fullName")
    @Mapping(source = "customer.email", target = "customer.email")
    @Mapping(source = "harvestId", target = "harvest.id")
    Sale toEntity(SaleRequestDTO saleRequestDTO);

    SaleResponseDTO toResponse(Sale sale);

}
