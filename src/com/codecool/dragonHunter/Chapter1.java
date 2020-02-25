package com.codecool.dragonHunter;

public class Chapter1 {
    // numbers of scenes to iterate on them
    private static final int[] SCENES = new int[] {0, 1, 2};
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
    *   3 three-dimentional arrays made to define, check and change conditions of the game
    *   each array levels:
    *       1. [arrays for each scene]
    *       2. [array of arrays for each possible choice]
    *       3. [array of things to iterate on] (for example items and values to add to inventory)
    */
    private static final String [][][] CHOICES = {
            // separating string in the 3rd dimension of the array is here to help check user response later
            {{"a", ". accept"}, {"b", ". refuse"}, {"c", ". bargain"}},
            {{"a", ". accept"}, {"b", ". refuse"}, {"c", ". bargain"}},
            {{"Press any key"}}
    };
    private static final String [][][] RESPONSES_RESULTS_HEADERS = {
            // "skip scene" and "next scene" will be validated and used to help control the flow of the game
            {{"Coins", "Daggers", "skip scene"}, {"skip scene"}, {"next scene"}},
            {{"Coins", "Daggers"}, {"next scene"}, {"Coins", "next scene"}},
            {{"next scene"}}
    };
    private static final int[][][] RESPONSES_RESULTS_VALUES = {
            {{-15, 1, 1}, {1}, {0}},
            {{-10, 1}, {0}, {-20, 0}},
            {{0}}
    };

    static void playChapter() {
        // for each scene (scene index)...
        for (int scene: SCENES) {
            // show instructions and user action options...
            Util.printInstruction(INSTRUCTIONS[scene]);
            Util.printChoices(CHOICES[scene]);

            // ...and activate and check the user choice
            boolean isChoiceValid = activateChoices(scene);
            // get user to make a choice again if choice is not valid
            while (! isChoiceValid) {
                isChoiceValid = activateChoices(scene);
            }
        }
    }
    static boolean activateChoices(int sceneIndex) {
        // get user response and initiate actionChose boolean to use later...
        String userResponse = Util.getUserResponse();
        boolean actionChose;

        // ...then for each possible choices in the scene check user chosen action
        for (int choiceIndex = 0; choiceIndex < CHOICES[sceneIndex].length; choiceIndex++) {
            String choiceValidInput = CHOICES[sceneIndex][choiceIndex][0];

            actionChose = Util.checkUserChoice(choiceValidInput, userResponse);
            if (actionChose) {
                // if the user chose one of the actions, add items to the inventory



                // and go to the next scene by returning the choice is valid
                return true;
            }
        }
        // return false if choice is not valid so you can restart the choice
        return false;
    }
}
