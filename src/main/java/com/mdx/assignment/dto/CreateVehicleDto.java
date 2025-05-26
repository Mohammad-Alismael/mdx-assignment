package com.mdx.assignment.dto;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class CreateVehicleDto {
    @NotBlank(message = "plateNumber is required")
    private String plateNumber;
    private String manufacturer;
    private String model;
    private Integer year;
    private String ownerName;
    private String createdBy;

    public CreateVehicleDto() {

    }

    public CreateVehicleDto(String plateNumber, String manufacturer, String model, Integer year, String ownerName, String createdBy) {
        this.plateNumber = plateNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.ownerName = ownerName;
        this.createdBy = createdBy;
    }


    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
