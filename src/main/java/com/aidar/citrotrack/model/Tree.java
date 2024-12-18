package com.aidar.citrotrack.model;

import com.aidar.citrotrack.model.enums.TreeProductivity;
import com.aidar.citrotrack.validation.ValidTree;
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
@Table(name = "Trees")
@ValidTree
public class Tree {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Plantation date cannot be null")
    @PastOrPresent(message = "Planting date must be in the past or present")
    private LocalDate plantingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id")
    private Field field;

    @Transient
    private TreeProductivity productivity;

    @Transient
    private int age;

    @OneToMany(mappedBy = "tree", fetch = FetchType.LAZY)
    private List<HarvestDetail> harvestDetails= new ArrayList<HarvestDetail>();


}
