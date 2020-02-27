package com.codecool.dragonHunter;

public class User {
    private static String[] statsHeaders;
    private static int[] statsValues;
    User() {
        statsHeaders = new String[] {"Health", "Strength"};
        statsValues = new int[] {80, 30};
    }
    public static String getStatsPrintVersion() {
        String statsString = "|";
        for (int statIndex = 0; statIndex < statsHeaders.length; statIndex++) {
            String header = statsHeaders[statIndex];
            int value = statsValues[statIndex];
            statsString += " " + header + ": " + value + " |";
        }
        return statsString;
    }

}
