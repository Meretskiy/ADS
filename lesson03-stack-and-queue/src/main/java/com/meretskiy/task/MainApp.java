package com.meretskiy.task;

import java.util.Scanner;

/**
 * Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * Создать класс для реализации дека.
 */
public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string...");
        String str = scanner.nextLine();

        reverseString(str);
    }

    private static void reverseString(String str) {
        Deque<Character> s = new DequeImpl<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            s.insertLeft(str.charAt(i));
        }

        while (!s.isEmpty()) {
            System.out.print(s.removeLeft());
        }
    }
}
