package com.mdx.assignment.services;

import com.mdx.assignment.dto.CreateVehicleDto;
import com.mdx.assignment.dto.ResponseVehicleDto;
import com.mdx.assignment.execptions.DuplicatePlateNumberException;
import com.mdx.assignment.execptions.VehicleNotFoundException;
import com.mdx.assignment.models.Vehicle;
import com.mdx.assignment.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    //create vehicle
    public void createVehicle(CreateVehicleDto vehicle){
        Vehicle vehicleEntity = DtoToEntity(vehicle);
        try {
            vehicleRepository.save(vehicleEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicatePlateNumberException("Plate number already exists: " + vehicle.getPlateNumber());
        }
    }
    //get all vehicles
    public List<ResponseVehicleDto> getAllVehicles(){
        return vehicleRepository.findAll()
                .stream()
                .map(vehicle ->
                        new ResponseVehicleDto(
                                vehicle.getId(),
                                vehicle.getPlateNumber(),
                                vehicle.getManufacturer(),
                                vehicle.getModel(),
                                vehicle.getYear(),
                                vehicle.getOwnerName(),
                                vehicle.getCreatedBy(),
                                vehicle.getCreatedAt())).toList();
    }
    //get vehicle
    public ResponseVehicleDto getVehicle(Long id){
        //get vehicle by id
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(String.format("vehicle not found with id: %d", id)));

        //convert entity to DTO
        return EntityToDto(vehicle);

    }
    //update vehicle
    public void updateVehicle(Long id, CreateVehicleDto vehicle){
        Vehicle vehicleDb = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(String.format("vehicle not found with id: %d", id)));
        vehicleDb.setPlateNumber(vehicle.getPlateNumber());
        vehicleDb.setManufacturer(vehicle.getManufacturer());
        vehicleDb.setModel(vehicle.getModel());
        vehicleDb.setYear(vehicle.getYear());
        vehicleDb.setOwnerName(vehicle.getOwnerName());
        vehicleDb.setCreatedBy(vehicle.getCreatedBy());
        try {
            vehicleRepository.save(vehicleDb);
        } catch (DataIntegrityViolationException e) {
        throw new DuplicatePlateNumberException("Plate number already exists: " + vehicle.getPlateNumber());
    }
    }
    //delete vehicle
    public void deleteVehicle(Long id){
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isPresent()){
            vehicleRepository.delete(vehicle.get());
        }else{
            throw new VehicleNotFoundException(String.format("vehicle not found with id: %d", id));
        }
    }

    private Vehicle DtoToEntity(CreateVehicleDto vehicle){
        return new Vehicle(vehicle.getPlateNumber(), vehicle.getManufacturer(), vehicle.getModel(), vehicle.getYear(), vehicle.getOwnerName(), vehicle.getCreatedBy());
    }

    private ResponseVehicleDto EntityToDto(Vehicle vehicle){
        return new ResponseVehicleDto(vehicle.getId(),vehicle.getPlateNumber(), vehicle.getManufacturer(), vehicle.getModel(), vehicle.getYear(), vehicle.getOwnerName(), vehicle.getCreatedBy(), vehicle.getCreatedAt());
    }
}
