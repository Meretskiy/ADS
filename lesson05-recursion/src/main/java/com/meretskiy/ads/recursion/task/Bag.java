package com.meretskiy.ads.recursion.task;

import java.util.ArrayList;

public class Bag {
    private final int bagSize;
    private final ArrayList<Item> items;
    private final ArrayList<Item> tempItems = new ArrayList<>();
    private int cursor;
    private final ArrayList<ItemsSet> itemsSets = new ArrayList<>();
    private ItemsSet completeItemsSet;

    public ItemsSet getCompleteItemsSet() {
        return completeItemsSet;
    }

    public Bag(int bagSize, ArrayList<Item> items) {
        this.bagSize = bagSize;
        this.items = items;
    }

    public Bag collectBag(){
        getItemsSet(bagSize);
        completeItemsSet = itemsSets.stream().min((o1, o2) -> o2.getCost() - o1.getCost()).get();
        return this;

    }

    private void getItemsSet(int freeBagSize) {
        if(cursor == items.size() || freeBagSize == 0) {
            itemsSets.add(new ItemsSet(tempItems));
            tempItems.remove(tempItems.size() - 1);
            return;
        }
        for (int i = cursor; i < items.size(); i++) {
            Item item = items.get(i);
            if(item.getSize() <= freeBagSize) {
                tempItems.add(item);
                cursor = 1 + i;
                getItemsSet(freeBagSize - item.getSize());
            }
        }
        if(tempItems.size() > 0) {
            itemsSets.add(new ItemsSet(tempItems));
            tempItems.remove(tempItems.size() - 1);
        }
    }
}
