package com.meretskiy.ads.trees.task06;

import java.util.Random;

/**
 * 1. Создать и запустить программу для построения двоичного дерева.
 *  В цикле построить двадцать деревьев с глубиной в 6 уровней. Данные, которыми необходимо заполнить узлы деревьев,
 *  представляются в виде чисел типа int. Число, которое попадает в узел, должно генерироваться случайным образом
 *  в диапазоне от -100 до 100.
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 */
public class MainClass {
    private static final int TREES = 20;
    private static final int TREE_MAX_LEVEL = 4;
    private static final int MAX_VALUE = 25;
    private static int balancedTreesCount;

    public static void main(String[] args) {
        System.out.println(calculatePercentageBalancedTrees() + "% of balanced trees.");
    }

    private static double calculatePercentageBalancedTrees() {
        Random rand = new Random();
        for (int i = 0; i < TREES; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>(TREE_MAX_LEVEL);
            for (int j = 0; j < (int) (Math.pow(2, TREE_MAX_LEVEL) - 1); j++) {
                tree.add(rand.nextInt(MAX_VALUE * 2 + 1) - MAX_VALUE);
            }
            if (tree.isBalanced()) {
                balancedTreesCount++;
            }
        }
        return (balancedTreesCount / (TREES * 1.0)) * 100;
    }
}
