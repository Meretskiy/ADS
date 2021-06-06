package com.meretskiy.ads.recursion.task;

import java.util.ArrayList;

/**
 * 1. Написать метод по возведению числа в степень с помощью рекурсии.
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 */
public class MainClass {

    private static double exp(double number, int degree) {
        if (degree < 0) throw new ArithmeticException("negative degree...");
        if (degree == 0 || number == 1) return 1;
        return number * exp(number, --degree);
    }

    public static void main(String[] args) {

        System.out.println(exp(2,5));
        System.out.println("---------------------");

        Bag bag = initBag();
        ItemsSet is = bag.collectBag().getCompleteItemsSet();

        System.out.println("Total cost: " + is.getCost() +"\n" +
                "Total weight: " + is.getSize() + "\n" +
                "Items list: " + is.getItems());
    }

    private static Bag initBag() {
        Bag bag = new Bag(5, new ArrayList<Item>(){{
            add(new Item(1, 4, "item1"));
            add(new Item(2, 3, "item2"));
            add(new Item(3, 5, "item3"));
            add(new Item(4, 2, "item4"));
            add(new Item(1, 1, "item5"));
        }});
        return bag;
    }
}
