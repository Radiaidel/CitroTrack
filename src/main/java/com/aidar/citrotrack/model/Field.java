package com.aidar.citrotrack.model;

import com.aidar.citrotrack.Validation.ValidField;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Fields")
@ValidField
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotNull(message = "Area is required")
    @DecimalMin(value = "0.1", message = "Minimum area is 0.1 hectare")
    @Column
    private double area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id")
    @NotNull(message = "Field must be associated with a farm")
    private Farm farm;


    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<Tree> trees = new ArrayList<>();

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<Harvest> harvests = new ArrayList<>();

}
