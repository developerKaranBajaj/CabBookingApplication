package com.cab.cabbookingapplication.service;

import com.cab.cabbookingapplication.dao.Driver;
import com.cab.cabbookingapplication.data.DriverData;
import com.cab.cabbookingapplication.dto.DriverDto;
import com.cab.cabbookingapplication.util.CloneUtil;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    private final DriverData driverData;

    public DriverService(DriverData driverData) {
        this.driverData = driverData;
    }

    public int addDriver(DriverDto driverDto) {
        Driver driver = CloneUtil.driverDtoToDao(driverDto);
        return driverData.addDriver(driver);
    }
}
