package UI;

import entities.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("Bob", "Bob", "bob@bugscorp.ca", "123");
        UI ui = new UI(user);
        ui.receiveCommands();
    }
}
