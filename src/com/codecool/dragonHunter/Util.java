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
        // for each choice option array...
        for (String[] choiceElements: choices) {
            // ... create a joint string of the full user-readable option
            String choice = "";
            for (String choiceElem: choiceElements) {
                choice += choiceElem;
            }
            // print the string
            System.out.println(choice);
        }
    }
}
