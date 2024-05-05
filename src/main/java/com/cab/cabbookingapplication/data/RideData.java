package com.cab.cabbookingapplication.data;


import com.cab.cabbookingapplication.dao.Driver;
import com.cab.cabbookingapplication.dao.Ride;
import com.cab.cabbookingapplication.dao.User;
import com.cab.cabbookingapplication.util.DistanceUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class RideData {
    private final Set<Ride> rides;
    private final Map<Integer, Ride> rideMap;
    private final DriverData driverData;
    private final UserData userData;
    private final int maxDistance = 5;

    public RideData(Set<Ride> rides, Map<Integer, Ride> rideMap, DriverData driverData, UserData userData) {
        this.rides = rides;
        this.rideMap = rideMap;
        this.driverData = driverData;
        this.userData = userData;
    }


    public int chooseRide(int driverId, int userId, double sourceX, double sourceY, double destX, double destY) {
        User user = userData.getUser(userId);
        Driver driver = driverData.getDriver(driverId);
        if(DistanceUtil.isInsideArea(sourceX, sourceY, driver.getCurrX(), driver.getCurrY(), maxDistance) && driver.isAvailable()) {
            Ride ride = new Ride(rides.size() + 1, driver, sourceX, sourceY, destX, destY, user);
            rides.add(ride);
            rideMap.put(ride.getId(), ride);
            return ride.getId();
        }
        return -1;
    }

    public List<Driver> findRides(double sourceX, double sourceY) {
        return driverData.getAllDrivers().stream().filter(k -> DistanceUtil.isInsideArea(sourceX, sourceY, k.getCurrX(), k.getCurrY(), maxDistance) && k.isAvailable()).toList();
    }
}
