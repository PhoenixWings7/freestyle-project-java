package com.codecool.inventory;

import static com.codecool.inventory.Inventory.addToinventory;

public class Main {

    public static void main(String[] args) {
        Inventory userInventory = new Inventory();
        String[] itemsToAdd = {"Daggers", "Minions", "Stones", "Swords", "Daggers"};
        int[] valuesToAdd = new int[] {1, 3, 10, 5, 34};
        addToinventory(userInventory.getItemsNames(), userInventory.getInventoryValues(), itemsToAdd, valuesToAdd);
        Inventory.printInventory(Inventory.getItemsNames(), Inventory.getInventoryValues());

    }
}
