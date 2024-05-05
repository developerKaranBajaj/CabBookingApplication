package com.cab.cabbookingapplication.config;


import com.cab.cabbookingapplication.dao.Driver;
import com.cab.cabbookingapplication.dao.Ride;
import com.cab.cabbookingapplication.dao.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class DataConfig {
    private final Set<User> users = new HashSet<>();
    private final Map<Integer, User> userMap = new HashMap<>();
    private final Set<Driver> drivers = new HashSet<>();
    private final Map<Integer, Driver> driverMap = new HashMap<>();
    private final Set<Ride> rides = new HashSet<>();
    private final Map<Integer, Ride> rideMap = new HashMap<>();

    @Bean()
    public Set<User> users() {
        return users;
    }

    @Bean
    public Map<Integer, User> userMap() {
        return userMap;
    }

    @Bean()
    public Set<Driver> drivers() {
        return drivers;
    }

    @Bean
    public Map<Integer, Driver> driversMap() {
        return driverMap;
    }

    @Bean()
    public Set<Ride> rides() {
        return rides;
    }

    @Bean
    public Map<Integer, Ride> rideMap() {
        return rideMap;
    }


}
