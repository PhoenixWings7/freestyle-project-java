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
                "I've heard you are here on a mission to kill a dragon and you need resources. \n" +
                "I can give you 1 dagger for 15 coins. Do you accept? \n" +
                "(enter a single letter to make a choice)",
        "Shopkeeper: You're as brave as people told me. 10 coins then.",
        "Shopkeeper: Alrighty then, good luck on your adventures! \n" +
                "Shopkeeper goes away.",
        "You enter a tavern. Only when you buy a beer, you realize that you’re missing 20 gold coins! " +
                "It appears the shopkeeper stole them from you. \n" +
                "What do you do?",
        "A pretty bartender approaches you. \n" +
                "Bartender: What would you like to order?\n",
        "You chase the shopkeeper down the road but you don’t see him. You reach a crossroads. \n" +
                "What do you do?",
        "You run down the chosen road but you don’t see the shopkeeper. You reach a crossroads. \n" +
                "What do you do?",
        "You finally see the shopkeeper. \n" +
                "What do you do?",
        "The shopkeeper admits he’s guilty of sealing your coins and gives them back to you. \n" +
                "You take them and go away with a smile on your face.",
        "A crowd gathers. The shopkeeper calls you a liar and you don’t have any evidence. \n" +
                "The crowd backs him up so you let it go and go away.",
        "You have amazingly muscular legs so you manage to flee. \n" +
                "You are satisfied and happy, you stole 50 coins!",
        "You didn’t find the shopkeeper. You realize you must have missed him. \n" +
                "It’s time to let it go.",
        "Congratulations! You’ve completed the first Chapter!"

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
            {{"Press enter."}},
            {{"a", ". chase the bastard - you’ll get them back!"}, {"b", ". let it go"}},
            {{"a", ". a roast (10 coins)"}, {"b", ". another beer (3coins) "}},
            {{"a", ". turn left"}, {"b", ". turn right"}, {"c", ". go straight"}, {"d", ". let it go"}},
            {{"a", ". turn left"}, {"b", ". turn right"}, {"c", ". go straight"}, {"d", ". let it go"}},
            {{"a", ". reason with him"}, {"b", ". shout at him, he’s a thief!"}, {"c", ". steal his pouch with gold and run"}},
            {{"Press enter."}},
            {{"Press enter."}},
            {{"Press enter."}},
            {{"Press enter."}},
            {{"Press enter."}}
    };
    private static final String [][][] ACTION_RESULTS_HEADERS = {
            // "skip scene" will be validated and used to help control the flow of the game
            // "next scene" is only here to create a non-empty array
            {{"Coins", "Daggers", "skip scene"}, {"Coins" ,"skip scene"}, {"next scene"}},
            {{"Coins", "Daggers"}, {"Coins"}, {"Coins"}},
            {{"next scene"}},
            {{"Strength", "skip scene"}, {"next scene"}},
            {{"Coins", "Strength", "skip scene"}, {"Coins", "Strength", "skip scene"}},
            {{"Strength"}, {"Strength"}, {"Strength"}, {"skip scene"}},
            {{"Strength"}, {"Strength", "skip scene"}, {"Strength", "skip scene"}, {"skip scene"}},
            {{"Coins"}, {"skip scene"}, {"Coins", "Strength", "skip scene"}},
            {{"skip scene"}},
            {{"skip scene"}},
            {{"skip scene"}},
            {{"next scene"}},
            {{"next scene"}}
    };
    private static final int[][][] ACTION_RESULTS_VALUES = {
            {{-35, 1, 1}, {-20, 1}, {0}},
            {{-30, 1}, {-20}, {-20}},
            {{0}},
            {{-5, 1}, {0}},
            {{-10, 50, 7}, {-3, -5, 7}},
            {{-5}, {-5}, {-5}, {6}},
            {{-5}, {-5, 4}, {-5, 4}, {4}},
            {{20}, {1}, {50, -10, 2}},
            {{3}},
            {{2}},
            {{1}},
            {{0}},
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

            // print dividing lines, inventory and user stats
            Util.printDividingLine();
            Util.printUserStats();
            Util.printDividingLine("-");
            Util.printInventory();
            Util.printDividingLine();

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
