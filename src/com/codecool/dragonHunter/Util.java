package com.codecool.dragonHunter;

import java.util.Scanner;

class Util {
    protected static String getUserResponse() {
        System.out.println("Your choice");
        Scanner inputObj = new Scanner(System.in);
        String userInput = inputObj.nextLine();
        return userInput;
    }

    protected static String getUserResponse(String header) {
        System.out.println(header);
        Scanner inputObj = new Scanner(System.in);
        String userInput = inputObj.nextLine();
        return userInput;
    }

    public static boolean checkUserChoice(String correctAnswer, String userAnswer) {
        return correctAnswer.matches(userAnswer);
    }

    public static void printInstruction(String instruction) {
        System.out.println(instruction);
    }

    public static void printChoices(String[][] choices) {
        for (String[] choiceElements: choices) {
            String choice = "";
            for (String choiceElem: choiceElements) {
                choice += choiceElem;
            }
            System.out.println(choice);
        }
    }
}
