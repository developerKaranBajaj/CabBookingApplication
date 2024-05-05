package com.cab.cabbookingapplication.service;


import com.cab.cabbookingapplication.dao.User;
import com.cab.cabbookingapplication.data.UserData;
import com.cab.cabbookingapplication.dto.UserDto;
import com.cab.cabbookingapplication.util.CloneUtil;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserData userData;

    public UserService(UserData userData) {
        this.userData = userData;
    }

    public int addUser(UserDto userDto) {
        User user = CloneUtil.userDtoToDao(userDto);
        return userData.addUser(user);
    }
}
