package com.cab.cabbookingapplication.service;


import com.cab.cabbookingapplication.data.RideData;
import com.cab.cabbookingapplication.dto.DriverDto;
import com.cab.cabbookingapplication.dto.RideDto;
import com.cab.cabbookingapplication.util.DistanceUtil;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RideService {
    private final RideData rideData;

    public RideService(RideData rideData) {
        this.rideData = rideData;
    }


    public List<RideDto> findRides(double sourceX, double sourceY) {
        return rideData.findRides(sourceX, sourceY).stream().map(k -> new RideDto(new DriverDto(k.getId(), k.getName(), k.getGender(), k.getAge(), k.getVehicleDetails(), k.getCurrX(),k.getCurrY()), DistanceUtil.calculateDistance(k.getCurrX(),k.getCurrY(),sourceX, sourceY))).toList();
    }

    public int chooseRide(int userId, int driverId, double sourceX, double sourceY, double destX, double destY) {
        return rideData.chooseRide(driverId, userId, sourceX, sourceY, destX, destY);
    }
}
