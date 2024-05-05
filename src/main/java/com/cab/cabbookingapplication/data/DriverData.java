package com.cab.cabbookingapplication.data;


import com.cab.cabbookingapplication.dao.Driver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Component
public class DriverData {
    private final Set<Driver> drivers;
    private final Map<Integer, Driver> driverMap;

    public DriverData(Set<Driver> drivers, Map<Integer, Driver> driverMap) {
        this.drivers = drivers;
        this.driverMap = driverMap;
    }


    public int addDriver(Driver driver) {
        if (driver.getId() != null) {
            return updateDriver(driver);
        } else {
            Driver driver1 = new Driver(drivers.size() + 1, driver.getName(),driver.getGender(),driver.getAge(), driver.getVehicleDetails(), driver.getCurrX(), driver.getCurrY(), driver.isAvailable());
            drivers.add(driver1);
            driverMap.put(driver1.getId(), driver1);
            return driver1.getId();
        }

    }

    public int updateDriver(Driver driver) {
        drivers.add(driver);
        driverMap.put(driver.getId(), driver);
        return driver.getId();
    }

    public List<Driver> getAllDrivers() {
        return new ArrayList<>(driverMap.values());
    }

    public Driver getDriver(int id) {
        return driverMap.get(id);
    }
}
