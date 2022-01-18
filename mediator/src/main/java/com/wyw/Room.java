package com.wyw;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<User> userList;

    public Room() {
        userList = new ArrayList<>();
    }

    public void add(User user) {
        userList.add(user);
    }

    public void sendMessage(User sender, String message) {
        for (User user : userList) {
            if (user != sender) {
                sender.sendMessage(user, message);
            }
        }
    }
}
