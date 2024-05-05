package com.cab.cabbookingapplication.dto.request;

import lombok.Data;

@Data
public class ChooseRideRequestDto {
    private final int driverId;
    private final int userId;
    private final double sourceX;
    private final double sourceY;
    private final double destX;
    private final double destY;
}
