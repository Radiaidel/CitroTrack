package com.aidar.citrotrack.model;

import com.aidar.citrotrack.model.enums.Seasons;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Harvests")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "Harvest date cannot be null")
    @PastOrPresent(message = "Harvest date must be in the past or present")
    private LocalDate harvestDate;

    @NotNull(message = "Season cannot be null")
    @Enumerated(EnumType.STRING)
    private Seasons season;

    @Column(name = "total_quantity", nullable = false)
    private double totalQuantity = 0.0;

    @OneToMany(mappedBy = "harvest", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HarvestDetail> harvestDetails= new ArrayList<HarvestDetail>();

    @OneToMany(mappedBy = "harvest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sale> SaleList = new ArrayList<Sale>();

}
