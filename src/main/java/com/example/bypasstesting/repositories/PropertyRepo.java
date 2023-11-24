package com.example.bypasstesting.repositories;

import com.example.bypasstesting.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Property, Integer> {
    Property findPropertyByPincode(Integer pincode);
}
