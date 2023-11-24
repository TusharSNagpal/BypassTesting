package com.example.bypasstesting.controllers;

import com.example.bypasstesting.payloads.PropertyDto;
import com.example.bypasstesting.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/property")
@CrossOrigin(origins = "*")

public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("/")
    public ResponseEntity<PropertyDto> registerProperty(@RequestBody PropertyDto propertyDto) {
        PropertyDto createPropertyDto = this.propertyService.registerProperty(propertyDto);
        return new ResponseEntity<>(createPropertyDto, HttpStatus.CREATED);
    }

    @PutMapping("/{prop_Id}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable Integer prop_Id) {
        PropertyDto updatedProperty = this.propertyService.updateProperty(propertyDto,prop_Id);
        return ResponseEntity.ok(updatedProperty);
    }

    @GetMapping("/{pincode}")
    public ResponseEntity<PropertyDto> searchPropertyforCust(@PathVariable Integer pincode) {
        return ResponseEntity.ok(this.propertyService.searchPropertyforCust(pincode));
    }

    @GetMapping("/{prop_id}")
    public ResponseEntity<PropertyDto> searchProperty(@PathVariable Integer prop_id) {
        return ResponseEntity.ok(this.propertyService.searchProperty(prop_id));
    }

    @DeleteMapping("/{prop_Id}")
    public void deleteProperty(@PathVariable Integer prop_Id) {
        this.propertyService.deleteProperty(prop_Id);
    }
}
