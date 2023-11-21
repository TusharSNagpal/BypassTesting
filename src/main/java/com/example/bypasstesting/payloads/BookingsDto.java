package com.example.bypasstesting.payloads;

import com.example.bypasstesting.entities.Customer;
import com.example.bypasstesting.entities.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingsDto {
    private Integer bookingId;
    private String prop_address;
    private String vehicle_no;
    private String in_date;
    private String out_date;
    private String price;
    private Customer customer;
    private Property property;
}
