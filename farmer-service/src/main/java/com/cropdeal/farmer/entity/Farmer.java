package com.cropdeal.farmer.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "farmers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String phone;
    private String address;

    private String bankAccountNumber;

    private String ifscCode;

    private boolean active;

}
