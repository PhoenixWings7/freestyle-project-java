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


    static int getSkippedScenesNum(String[] choiceResultsHeaders, int[] choiceResultValues, String keyword) {
        // get the index of the "skip scene" choice label from headers
        int skippingSceneIndex = Arrays.asList(choiceResultsHeaders).indexOf(keyword);
        // if there are scenes to skip (you get skipSceneIndex < 0 if there's no "skip scene" header) ...
        boolean skipScene = skippingSceneIndex >= 0;
        int numOfSkips = 0;
        if (skipScene) {
            numOfSkips = choiceResultValues[skippingSceneIndex];
        }
        // return number of scenes to skip or 0
        return numOfSkips;
    }

    static boolean validateUserChoice(String correctAnswer, String userAnswer) {
        if (correctAnswer.equals("Press enter.")){
            return true;
        }
        return correctAnswer.matches(userAnswer);
    }

}
