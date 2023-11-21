package com.example.bypasstesting.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/owner")
@CrossOrigin(origins = "*")

public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PostMapping("/")
    public ResponseEntity<OwnerDto> registerOwner(@RequestBody OwnerDto ownerDto) {
        OwnerDto registerOwnerDto = this.ownerService.registerDwner(ownerDto);
        return new ResponseEntity<>(registerOwnerDto, HttpStatus.CREATED);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerDto> getOwner(@PathVariable Integer doctorId) {
        return ResponseEntity.ok(this.ownerService.getDoctorById(ownerId));
    }



}
