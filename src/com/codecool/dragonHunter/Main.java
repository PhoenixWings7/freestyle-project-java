package com.codecool.dragonHunter;

public class Main {

    public static void main(String[] args) {
        // display game intro
        Util.printInstruction("Welcome to the Dragon Hunter. \n" +
                "You're going to play a role of a famous dragon hunter. Enjoy! \n");
        // create a new User object
        User newUser = new User();

        Chapter1.playChapter();

    }
}
