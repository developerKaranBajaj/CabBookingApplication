package com.cab.cabbookingapplication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Ride {

    private final int id;
    private final Driver driver;
    private final double sourceX;
    private final double sourceY;
    private final double destX;
    private final double destY;
    private final User user;
}
