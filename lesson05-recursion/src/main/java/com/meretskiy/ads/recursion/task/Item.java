package com.meretskiy.ads.recursion.task;

public class Item {
    private final int size;
    private final int cost;
    private final String name;

    public Item(int size, int cost, String name) {
        this.size = size;
        this.cost = cost;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "size=" + size +
                ", cost=" + cost +
                ", name='" + name + '\'' +
                '}';
    }
}
