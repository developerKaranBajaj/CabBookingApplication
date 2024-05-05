package com.cab.cabbookingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class UserDto {
    private final String name;
    private final String gender;
    private final int age;
}
