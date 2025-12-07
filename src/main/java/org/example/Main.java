package org.example;

public class Main {
    public static void main(String[] args) {
        String dbUrl = args[0];
        String dbUser = args[1];
        String dbPassword = args[2];

        UserInterface ui = new UserInterface();
        ui.display(dbUrl, dbUser, dbPassword);
    }
}