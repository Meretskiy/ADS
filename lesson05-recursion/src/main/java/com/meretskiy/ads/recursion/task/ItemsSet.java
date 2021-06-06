package com.meretskiy.ads.recursion.task;

import java.util.ArrayList;

public class ItemsSet {
    private final int size;
    private final int cost;
    private final ArrayList<Item> items;

    public ItemsSet(ArrayList<Item> items){
        this.items = new ArrayList<>(items);
        this.size = calcSize(items);
        this.cost = calcCost(items);
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    private int calcSize(ArrayList<Item> items){
        int size = 0;
        for (Item i : items) size += i.getSize();
        return size;
    }

    private int calcCost(ArrayList<Item> items){
        int cost = 0;
        for (Item i : items) cost += i.getCost();
        return cost;
    }
}
