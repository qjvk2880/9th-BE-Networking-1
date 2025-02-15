package com.cotato.networking1.controller;

import com.cotato.networking1.domain.dto.PropertyListResponse;
import com.cotato.networking1.domain.dto.PropertyRegisterRequest;
import com.cotato.networking1.domain.dto.PropertyRegisterResponse;
import com.cotato.networking1.domain.enttiy.Property;
import com.cotato.networking1.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    @GetMapping()
    public ResponseEntity<PropertyListResponse> getAllByZipCode(@RequestParam("zip-code") String zipCode) {
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getAllByZipCode(zipCode));
    }

    @PostMapping()
    public ResponseEntity<PropertyRegisterResponse> registerProperty(@RequestBody PropertyRegisterRequest property) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.registerProperty(property));
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteProperty(@RequestParam("road-name-address") String roadNameAddress) {
        propertyService.deleteByRoadNameAddress(roadNameAddress);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
