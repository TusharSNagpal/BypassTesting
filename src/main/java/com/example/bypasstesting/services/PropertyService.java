package com.example.bypasstesting.services;

import com.example.bypasstesting.payloads.OwnerDto;
import com.example.bypasstesting.payloads.PropertyDto;

public interface PropertyService {

    PropertyDto registerProperty(PropertyDto propertyDto);

    PropertyDto updateProperty(PropertyDto propertyDto);

    PropertyDto searchProperty(Integer prop_id);

    PropertyDto searchPropertyforCust(Integer pincode);

    void deleteProperty(Integer prop_id);

}
