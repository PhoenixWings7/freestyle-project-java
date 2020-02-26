package com.codecool.dragonHunter;

import java.util.Arrays;

public class Choice {

    int numOfSkips;
    boolean isChoiceValid;

    Choice(String choiceValidInput, String userInput,
            String[] choiceResultsHeaders, int[] choiceResultsValues) {
        isChoiceValid = validateUserChoice(choiceValidInput, userInput);
        numOfSkips = getSkippedScenesNum(choiceResultsHeaders, choiceResultsValues, "skip scene");
    }

/*
    static boolean validateChoice(int sceneIndex, String[][][] choices) {
        // get user response and initiate actionChose boolean to use later...
        String userResponse = Util.getUserResponse();
        boolean actionChose;

        // ...then for each possible choices in the scene check user chosen action
        for (int choiceIndex = 0; choiceIndex < choices[sceneIndex].length; choiceIndex++) {
            String choiceValidInput = choices[sceneIndex][choiceIndex][0];

            actionChose = checkUserChoice(choiceValidInput, userResponse);
            if (actionChose) {
                // if the user chose one of the actions, add items to the inventory



                // and go to the next scene by returning the choice is valid
                return true;
            }
        }
        // return false if choice is not valid so you can restart the choice
        return false;
    }
*/

    static int getSkippedScenesNum(String[] choiceResultsHeaders, int[] choiceResultValues, String keyword) {
        int skippingSceneIndex = Arrays.asList(choiceResultsHeaders).indexOf(keyword);
        boolean skipScene = skippingSceneIndex >= 0;
        int numOfSkips = 0;
        if (skipScene) {
            numOfSkips = choiceResultValues[skippingSceneIndex];
        }
        return numOfSkips;
    }

    static boolean validateUserChoice(String correctAnswer, String userAnswer) {
        return correctAnswer.matches(userAnswer);
    }

}
