package com.meretskiy.task;

import java.util.Random;

/**
 * 1. Создать массив большого размера (100_000 элементов).
 * 2. Написать методы удаления, добавления, поиска элемента массива.
 * 3. Заполнить массив случайными числами.
 * 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
 */
public class MainClass {
    private static final int INITIAL_CAPACITY = 100_000;
    private static final int MAX_VALUE = 100_000;

    public static void main(String[] args) {
        MyArrayImpl<Integer> myArray = new MyArrayImpl<>(INITIAL_CAPACITY);

        Random random = new Random();

        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            myArray.add(random.nextInt(MAX_VALUE));
        }

        MyArrayImpl<Integer> myArray2 = (MyArrayImpl<Integer>) myArray.copy();
        MyArrayImpl<Integer> myArray3 = (MyArrayImpl<Integer>) myArray.copy();

        long currentTime = System.currentTimeMillis();
        myArray.sortBubble();
        System.out.println("Bubble sort: " + (System.currentTimeMillis() - currentTime));

        long currentTime2 = System.currentTimeMillis();
        myArray2.sortSelect();
        System.out.println("Select sort: " + (System.currentTimeMillis() - currentTime2));

        long currentTime3 = System.currentTimeMillis();
        myArray3.sortInsert();
        System.out.println("Insert sort: " + (System.currentTimeMillis() - currentTime3));
    }

    /*
        Output:
                Bubble sort: 84455
                Select sort: 17917
                Insert sort: 16763
     */
}
