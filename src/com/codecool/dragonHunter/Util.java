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

    public static void printUserStats() {
        String stats = User.getStatsPrintVersion();
        System.out.print("\n");
        printInstruction(stats);
    }

    public static void printInventory() {
        Inventory.printInventory();
    }

    public static void printDividingLine () {
        printDividingLine(30);
    }

    public static void printDividingLine (int multiplier) {
        printDividingLine(multiplier, "_");
    }

    public static void printDividingLine (String lineElement) {
        printDividingLine(30, lineElement);
    }

    public static void printDividingLine (int multiplier, String lineElement) {
        // use recursion to print a line
        if (multiplier>0) {
            System.out.print(lineElement);
            printDividingLine(multiplier-1, lineElement);
        }
        else {
            // if it's the last element, go to a new line
            System.out.print("\n");
        }
    }
}
