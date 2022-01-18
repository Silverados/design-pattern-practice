package com.wyw;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class User {
    private final String name;

    public void sendMessage(User user, String message) {
        System.out.println(this + " sendMessage: " + message);
        user.receiveMessage(message);
    }

    public void receiveMessage(String message) {
        System.out.println(this + " receiveMessage: " + message);
    }

    public void sendMessage(Room room, String message) {
        room.sendMessage(this, message);
    }
}
