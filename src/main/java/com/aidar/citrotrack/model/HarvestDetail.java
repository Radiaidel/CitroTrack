package com.aidar.citrotrack.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "harvest_details")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDetail {


    @EmbeddedId
    private HarvestDetailId id;


    @MapsId("harvestId")
    @ManyToOne
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;

    @MapsId("treeId")
    @ManyToOne
    @JoinColumn(name = "tree_id")
    private Tree tree;

    @Positive(message = "Quantity must be a positive number")
    private Double quantity;
}
