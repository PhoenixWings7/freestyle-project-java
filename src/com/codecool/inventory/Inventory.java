package com.codecool.inventory;


import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class Inventory {
    protected static void printInventory(String[] inventoryNames, int[] inventoryValues) {
        // print the header of inventory
        System.out.println("Your inventory");
        for (int itemIndex = 0; itemIndex < inventoryNames.length; itemIndex++) {
            try {
                String itemName = inventoryNames[itemIndex];
                int itemValue = inventoryValues[itemIndex];
                // print one line for item name and value
                System.out.println(itemName + ":" + itemValue);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Oops... Can't print the Inventory, something went wrong.");
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    protected static int[] addToinventory(String[] inventoryNames, int[] inventoryValues,
                                          String[] objectsToAdd, int[] valuesToAdd) {
        for (int i = 0; i < objectsToAdd.length; i++) {
            // get object name and it's value to add to inventory
            String objectToAdd = objectsToAdd[i];
            int valueToAdd = valuesToAdd[i];

            int inventoryObjIndex = Arrays.asList(inventoryNames).indexOf(objectToAdd);
            boolean inventoryContainsObj = (inventoryObjIndex >= 0);
            if (inventoryContainsObj) {
                inventoryValues[inventoryObjIndex] += valueToAdd;
            }
        }
        return inventoryValues;
    }

    public static void main(String[] args) {
        String[] inventoryNames = {"Daggers", "Swords", "Stones", "Troops"};
        int[] inventoryValues = new int[] {1, 3, 0, 12};

        printInventory(inventoryNames, inventoryValues);

        String[] itemsToAdd = {"Daggers", "Minions", "Stones", "Swords", "Daggers"};
        int[] valuesToAdd = new int[] {1, 3, 10, 5, 34};
        inventoryValues = addToinventory(inventoryNames, inventoryValues, itemsToAdd, valuesToAdd);

        printInventory(inventoryNames, inventoryValues);
    }
}