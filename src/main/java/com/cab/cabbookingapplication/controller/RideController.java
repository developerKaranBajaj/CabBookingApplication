package com.cab.cabbookingapplication.controller;

import com.cab.cabbookingapplication.dto.RideDto;
import com.cab.cabbookingapplication.dto.request.ChooseRideRequestDto;
import com.cab.cabbookingapplication.dto.request.FindAndChooseRideRequestDto;
import com.cab.cabbookingapplication.dto.request.FindRideRequestDto;
import com.cab.cabbookingapplication.service.RideService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController(value = "/ride")
public class RideController {
    private final RideService rideService;
    ObjectMapper mapper = new ObjectMapper();

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/findRides")
    public ResponseEntity<Map<String,String>> findRide(@RequestBody FindRideRequestDto findRideRequestDto) throws JsonProcessingException {
        List<RideDto> rideDtos =  rideService.findRides(findRideRequestDto.getSourceX(), findRideRequestDto.getSourceY());
        String json = mapper.writeValueAsString(rideDtos);

        if(rideDtos==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
                put("response", "fail");
            }});
        }else {
            return ResponseEntity.ok(new HashMap<>() {{
                put("response", "success");
                put("data", json);
            }});
        }
    }

    @PostMapping("/chooseRide")
    public ResponseEntity<Map<String, String>> chooseRide(@RequestBody ChooseRideRequestDto chooseRideRequestDto) {
        int rideId = rideService.chooseRide(chooseRideRequestDto.getUserId(), chooseRideRequestDto.getDriverId(), chooseRideRequestDto.getSourceX(), chooseRideRequestDto.getSourceY(), chooseRideRequestDto.getDestX(), chooseRideRequestDto.getDestY());
        if(rideId == -1){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
                put("response", "fail");
            }});
        }else{
            return ResponseEntity.ok(new HashMap<>() {{
                put("response", "success");
                put("id", String.valueOf(rideId));
            }});
        }
    }
    @GetMapping("/findAndChooseRide")
    public ResponseEntity<Map<String, String>> findAndChooseRide(@RequestBody FindAndChooseRideRequestDto findAndChooseRideRequestDto) {
        List<RideDto> rides = rideService.findRides(findAndChooseRideRequestDto.getSourceX(), findAndChooseRideRequestDto.getSourceY());
        if(rides.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new HashMap<>(){{
                put("response", "failure");
                put("message", "rides not available");
            }});
        }else{
            int rideId = rideService.chooseRide(findAndChooseRideRequestDto.getUserId(), rides.get(0).getDriver().getId(), findAndChooseRideRequestDto.getSourceX(), findAndChooseRideRequestDto.getSourceY(), findAndChooseRideRequestDto.getDestX(), findAndChooseRideRequestDto.getDestY());
            if(rideId == -1){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new HashMap<>() {{
                    put("response", "fail");
                }});
            }else
                return ResponseEntity.ok(new HashMap<>() {{
                    put("response", "success");
                    put("ride id", String.valueOf(rideId));
                }});
            }
        }

    }
