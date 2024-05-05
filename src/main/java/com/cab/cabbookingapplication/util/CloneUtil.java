package com.cab.cabbookingapplication.util;


import com.cab.cabbookingapplication.dao.Driver;
import com.cab.cabbookingapplication.dao.User;
import com.cab.cabbookingapplication.dto.DriverDto;
import com.cab.cabbookingapplication.dto.UserDto;

public class CloneUtil {
    public static User userDtoToDao(UserDto userDto){
        return new User(null, userDto.getName(), userDto.getGender(), userDto.getAge());
    }

    public static Driver driverDtoToDao(DriverDto driverDto){
        return new Driver(null, driverDto.getName(), driverDto.getGender(), driverDto.getAge(), driverDto.getVehicleDetail(), driverDto.getCurrX(), driverDto.getCurrY(), true );
    }




}
