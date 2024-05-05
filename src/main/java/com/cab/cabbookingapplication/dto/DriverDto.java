package com.cab.cabbookingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class DriverDto {
    private final int id;
    private final String name;
    private final String gender;
    private final int age;
    private final String vehicleDetail;
    private final double currX;
    private final double currY;

}
