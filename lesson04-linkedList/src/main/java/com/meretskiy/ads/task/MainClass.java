package com.meretskiy.ads.task;

/**
 * Реализовать цикл forEach для простого связанного списка
 */
public class MainClass {

    public static void main(String[] args) {

        testForEach();
    }

    private static void testForEach() {

        MyLinkedList<Integer> linkedList = new SimpleMyLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        for(Object value: linkedList) {
            System.out.println(value);
        }
    }
}

