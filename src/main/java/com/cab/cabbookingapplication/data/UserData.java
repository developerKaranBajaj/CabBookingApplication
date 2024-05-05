package com.cab.cabbookingapplication.data;


import com.cab.cabbookingapplication.dao.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class UserData {
    private final Set<User> users;
    private final Map<Integer, User> userMap;

    public UserData(Set<User> users, Map<Integer, User> userMap) {
        this.users = users;
        this.userMap = userMap;
    }

    public int addUser(User user) {
        if (user.getId() != null) {
            return updateUser(user);
        } else {
            User user1 = new User(users.size() + 1, user.getName(), user.getGender(), user.getAge());
            users.add(user1);
            userMap.put(user1.getId(), user1);
            return user1.getId();
        }

    }

    public int updateUser(User user) {
        users.add(user);
        userMap.put(user.getId(), user);
        return user.getId();
    }

    public User getUser(int userId) {
        return userMap.get(userId);
    }
}
