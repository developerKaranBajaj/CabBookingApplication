package com.cab.cabbookingapplication.controller;


import com.cab.cabbookingapplication.dto.DriverDto;
import com.cab.cabbookingapplication.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/addDriver")
    public ResponseEntity<Map<String, String>> addDriver(@RequestBody DriverDto driver) {
        int id = driverService.addDriver(driver);

        if(id==-1){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new HashMap<>() {{
                put("response", "fail");
            }});
        }else {
            return ResponseEntity.ok(new HashMap<>() {{
                put("response", "success");
                put("id", String.valueOf(id));
            }});
        }
    }
}
