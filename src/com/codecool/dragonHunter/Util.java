package com.codecool.dragonHunter;

import java.util.Scanner;

class Util {
    protected static String getUserResponse() {
        return getUserResponse("Your choice: ");
    }

    protected static String getUserResponse(String header) {
        System.out.println(header);
        Scanner inputObj = new Scanner(System.in);
        return inputObj.nextLine();
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
