package com.codecool.dragonHunter;

import java.util.Arrays;

public class Chapter1 {
    // chapter intro
    private static final String INTRO = "Chapter 1\n";

    /*
         array of plot instructions in the form: [scene1 instructions, scene2 instructions, ...]
        there has to be a single instruction String for each choice instruction
    */
    private static final String[] INSTRUCTIONS = {
        "Shopkeeper: Hi there, courageous traveler! \n" +
                "I've heard you are here on a mission to kill the dragon and you need resources. \n" +
                "I can give you 1 dagger for 15 coins. Do you accept? \n" +
                "(enter a single letter to make a choice)",
        "Shopkeeper: You're as brave as people told me. 10 coins then.",
        "Shopkeeper: Alrighty then, good luck on your adventures! \n" +
                "Shopkeeper goes away."
    };
    /*
    *   3 three-dimensional arrays made to define, check and change conditions of the game
    *   each array levels:
    *       1. [arrays for each scene]
    *       2. [array of arrays for each possible choice]
    *       3. [array of things to iterate on] (for example items and values to add to inventory)
    */
    private static final String [][][] CHOICES = {
            // separating string in the 3rd dimension of the array is here to help check user response later
            {{"a", ". accept"}, {"b", ". refuse"}, {"c", ". bargain"}},
            {{"a", ". accept"}, {"b", ". refuse"}, {"c", ". bargain"}},
            {{"Press any key to end the chapter."}}
    };
    private static final String [][][] ACTION_RESULTS_HEADERS = {
            // "skip scene" will be validated and used to help control the flow of the game
            // "next scene" is only here to create a non-empty array
            {{"Coins", "Daggers", "skip scene"}, {"skip scene"}, {"next scene"}},
            {{"Coins", "Daggers"}, {"next scene"}, {"Coins"}},
            {{"next scene"}}
    };
    private static final int[][][] ACTION_RESULTS_VALUES = {
            {{-15, 1, 1}, {1}, {0}},
            {{-10, 1}, {0}, {-20}},
            {{0}}
    };

    static void playChapter() {
        // display first chapter welcome
        Util.printInstruction(INTRO);

        // for each scene (scene index) except the last because it can't have any choices...
        for (int sceneIndex = 0; sceneIndex < INSTRUCTIONS.length; sceneIndex++) {
            // initiate actionChose boolean to use later...
            boolean actionChose = false;

            String[][] sceneChoices = CHOICES[sceneIndex];
            String sceneInstructions = INSTRUCTIONS[sceneIndex];
            int numOfSkips = 0;

            // show instructions and user action options...
            Util.printInstruction(sceneInstructions);
            Util.printChoices(sceneChoices);

            // break the loop if it's the last scene
            if (sceneIndex >= INSTRUCTIONS.length-1){
                Util.getUserResponse("");
                break;
            }
            // get user response
            String userResponse = Util.getUserResponse();


            // get user to make a choice again if choice is not valid
            for (int choiceIndex = 0; choiceIndex < sceneChoices.length; choiceIndex++) {

                String choiceValidInput = CHOICES[sceneIndex][choiceIndex][0];
                String[] choiceResultsHeaders = ACTION_RESULTS_HEADERS[sceneIndex][choiceIndex];
                int[] choiceResultsValues = ACTION_RESULTS_VALUES[sceneIndex][choiceIndex];

                Choice choice = new Choice(choiceValidInput, userResponse, choiceResultsHeaders, choiceResultsValues);
                if (choice.isChoiceValid) {
                    // add items to inventory
                    Inventory.addToinventory(choiceResultsHeaders, choiceResultsValues);
                    // set number of scenes to skip based on the user choice
                    numOfSkips = choice.numOfSkips;
                    // user chose a valid action
                    actionChose = true;

                }
            }
            // repeat the scene if user chose invalid option
            if (!actionChose) {
                sceneIndex-=1;
                continue;
            }

            // skip scenes if the choice's result defines it
            if (numOfSkips > 0) {
                sceneIndex+=numOfSkips;
            }
        }
    }
}
