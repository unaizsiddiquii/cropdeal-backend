package com.cropdeal.cropservice.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "crops")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cropName;

    @Column(nullable = false)
    private String cropType;

    @Column(nullable = false)
    private Double pricePerKg;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String farmerId;
}
