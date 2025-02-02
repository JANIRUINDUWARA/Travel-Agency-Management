package com.example.Packages.Microservice.model;
//meka thama entity class eka
//represents a database table
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long packageId;

    private String packageName;

    private String description;

    private String destination;

    private int durationDays;

    private BigDecimal price;

    private int availableSlots;
}