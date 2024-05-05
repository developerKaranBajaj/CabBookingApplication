package com.cab.cabbookingapplication.dto.request;

import lombok.Data;

@Data
public class FindRideRequestDto {
    private final double sourceX;
    private final double sourceY;
}
