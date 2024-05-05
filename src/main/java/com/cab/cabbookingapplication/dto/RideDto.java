package com.cab.cabbookingapplication.dto;



import lombok.Data;


@Data
public class RideDto {

    private final DriverDto driver;
    private final double distance;

}
