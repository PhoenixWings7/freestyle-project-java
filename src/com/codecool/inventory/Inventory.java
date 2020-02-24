package com.codecool.inventory;


import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class Inventory {
    protected static String[] inventoryNames;
    protected static int[] inventoryValues;

    Inventory() {
        // assign first inventory content
        inventoryNames = new String[] {"Daggers", "Swords", "Troops", "Stones", "Coins", "Gems"};
        inventoryValues = new int[] {1, 0, 0, 0, 100, 10};
    }

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
    protected static String[] getItemsNames() {
        return inventoryNames;
    }
    protected static int[] getInventoryValues() {
        return inventoryValues;
    }
}