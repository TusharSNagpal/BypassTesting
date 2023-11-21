package com.example.bypasstesting.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/property")
@CrossOrigin(origins = "*")

public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping("/")
    public ResponseEntity<PropertyDto> registerProperty(@RequestBody PropertyDto propertyDto) {
        PropertyDto createDoctorDto = this.propertyService.registerProperty(doctorDto);
        return new ResponseEntity<>(registerPropertyDto, HttpStatus.CREATED);
    }

    @PutMapping("/{prop_Id}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable Integer prop_Id) {
        PropertyDto updatedDoctor = this.propertyService.updateProperty(propertyDto,prop_Id);
        return ResponseEntity.ok(updatedProperty);
    }

    @GetMapping("/{prop_Id}")
    public ResponseEntity<PropertyDto> getProperty(@PathVariable Integer prop_Id) {
        return ResponseEntity.ok(this.propertyService.getPropertyById(prop_Id));
    }

    @DeleteMapping("/{prop_Id}")
    public void deleteProperty(@PathVariable Integer prop_Id) {
        this.propertyService.deleteProperty(prop_Id);
    }
}
