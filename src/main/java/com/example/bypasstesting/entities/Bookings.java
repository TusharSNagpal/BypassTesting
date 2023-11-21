package com.example.bypasstesting.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @Column(nullable = false)
    private String propid;

    @Column(nullable = false)
    private String prop_address;

    @Column(nullable = false)
    private String customer_id;

    @Column(nullable = false)
    private String vehicle_no;

    @Column(nullable = false)
    private String in_date;

    @Column(nullable = false)
    private String out_date;

    @Column(nullable = false)
    private String price;
}
