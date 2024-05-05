package com.cab.cabbookingapplication.controller;


import com.cab.cabbookingapplication.dto.UserDto;
import com.cab.cabbookingapplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody UserDto user) {
        int id = userService.addUser(user);

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
