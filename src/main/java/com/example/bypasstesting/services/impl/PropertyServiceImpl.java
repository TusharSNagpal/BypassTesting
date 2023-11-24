package com.example.bypasstesting.services.impl;

import com.example.bypasstesting.entities.Owner;
import com.example.bypasstesting.entities.Property;
import com.example.bypasstesting.exceptions.ResourceNotFoundException;
import com.example.bypasstesting.payloads.OwnerDto;
import com.example.bypasstesting.payloads.PropertyDto;
import com.example.bypasstesting.repositories.OwnerRepo;
import com.example.bypasstesting.repositories.PropertyRepo;
import com.example.bypasstesting.services.PropertyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private ModelMapper modelMapper;

    public PropertyDto registerProperty(PropertyDto propertyDto){
        Property property = this.modelMapper.map(propertyDto, Property.class);
        Property savedProperty = this.propertyRepo.save(property);
        return this.modelMapper.map(savedProperty, PropertyDto.class);
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto, Integer prop_id){
        Property property = this.propertyRepo.findById(prop_id).orElseThrow(()->new ResourceNotFoundException("Property", "Property ID", prop_id));
        property.setSlots(propertyDto.getSlots());
        property.setProp_address(propertyDto.getProp_address());
        property.setPincode(propertyDto.getPincode());
        Property updatedProperty = this.propertyRepo.save(property);
        return this.modelMapper.map(updatedProperty, PropertyDto.class);
    }

    public PropertyDto searchProperty(Integer prop_id){
        Property propertyFound = this.propertyRepo.findById(prop_id).orElseThrow(()->new ResourceNotFoundException("Property", "Property ID", prop_id));
        return this.modelMapper.map(propertyFound, PropertyDto.class);
    }

    @Override
    public void deleteProperty(Integer prop_id) {
        Property property = this.propertyRepo.findById(prop_id).orElseThrow(() -> {
            return new ResourceNotFoundException("Property", "Property ID", prop_id);
        });
        this.propertyRepo.delete(property);
    }

    public PropertyDto searchPropertyforCust(Integer pincode){
        Property propertycust = this.propertyRepo.findPropertyByPincode(pincode);
        return this.modelMapper.map(propertycust, PropertyDto.class);
    }

}
