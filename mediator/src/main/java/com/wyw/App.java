package com.wyw;

public class App {
    public static void main(String[] args) {
        var user1 = new User("A");
        var user2 = new User("B");
        var user3 = new User("C");

        var message = "Hello everybody!!";
        user1.sendMessage(user2, message);
        user1.sendMessage(user3, message);

        System.out.println("--------------------------------------------------------");

        var room = new Room();
        room.add(user1);
        room.add(user2);
        room.add(user3);

        user1.sendMessage(room, message);
    }
}
