package com.codecool.dragonHunter;

import static com.codecool.dragonHunter.Inventory.addToinventory;

public class Main {

    public static void main(String[] args) {
        // display game intro
        Util.printInstruction("Welcome to the Dragon Hunter. \n" +
                "You're going to play a role of a famous dragon hunter. Enjoy! \n");

        Chapter1.playChapter();

    }
}
