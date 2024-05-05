package com.cab.cabbookingapplication.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Driver {
    private final Integer id;
    private final String name;
    private final String gender;
    private final int age;
    private final String vehicleDetails;
    private final double currX;
    private final double currY;
    private final boolean available;
}
