package com.aidar.citrotrack.model;
import com.aidar.citrotrack.validation.ValidHarvestDetail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Entity
@Table(name = "harvest_details")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ValidHarvestDetail

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
