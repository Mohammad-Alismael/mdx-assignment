package com.mdx.assignment.controllers;

import com.mdx.assignment.dto.CreateVehicleDto;
import com.mdx.assignment.dto.ResponseVehicleDto;
import com.mdx.assignment.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
public class VehicleController {
//    common mistake people tend to use an entity model as a request and response body

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Object> createVehicle(@Valid @RequestBody CreateVehicleDto vehicle){
        vehicleService.createVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED); // return 201 created
    }

    @GetMapping
    public List<ResponseVehicleDto> getVehicles(){
        return vehicleService.getAllVehicles(); // return 200 ok
    }

    @GetMapping("{id}")
    public ResponseVehicleDto getVehicle(@PathVariable Long id){
        return vehicleService.getVehicle(id); // return 200 ok
    }

    @PutMapping("{id}")
    public void updateVehicle(@PathVariable Long id, @Valid @RequestBody CreateVehicleDto vehicle ){
        vehicleService.updateVehicle(id,vehicle); // return 200 ok

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // return 204 created
    }
}
