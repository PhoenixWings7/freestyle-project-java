package com.codecool.dragonHunter;


import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class Inventory {

    protected static final String[] INVENTORY_NAMES = new String[] {"Daggers", "Swords", "Troops", "Stones", "Coins", "Gems"};
    protected static final int[] INVENTORY_VALUES = new int[] {1, 0, 0, 0, 100, 10};

    protected static void printInventory() {
        // print the header of inventory
        System.out.println("Your inventory");
        for (int itemIndex = 0; itemIndex < INVENTORY_NAMES.length; itemIndex++) {
            try {
                String itemName = INVENTORY_NAMES[itemIndex];
                int itemValue = INVENTORY_VALUES[itemIndex];
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

    protected static int[] addToinventory(String[] objectsToAdd, int[] valuesToAdd) {
        for (int i = 0; i < objectsToAdd.length; i++) {
            // get object name and it's value to add to inventory
            String objectToAdd = objectsToAdd[i];
            int valueToAdd = valuesToAdd[i];

            int inventoryObjIndex = Arrays.asList(INVENTORY_NAMES).indexOf(objectToAdd);
            boolean inventoryContainsObj = (inventoryObjIndex >= 0);
            if (inventoryContainsObj) {
                INVENTORY_VALUES[inventoryObjIndex] += valueToAdd;
            }
        }
        return INVENTORY_VALUES;
    }
    protected static String[] getItemsNames() {
        return INVENTORY_NAMES;
    }
    protected static int[] getInventoryValues() {
        return INVENTORY_VALUES;
    }
}