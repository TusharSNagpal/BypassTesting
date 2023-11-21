package com.example.bypasstesting.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyId;

    @Column(nullable = false)
    private Integer slots;

    @Column(nullable = false)
    private String propertyAddress;

    @Column(nullable = false)
    private Integer pincode;

    @ManyToOne
    @JoinColumn(name="ownerId")
    private Owner owner;
}