package com.aidar.citrotrack.repository;

import com.aidar.citrotrack.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository  extends JpaRepository<Sale, Long> {
}
