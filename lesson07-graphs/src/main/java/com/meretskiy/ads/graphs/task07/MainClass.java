package com.meretskiy.ads.graphs.task07;

import com.meretskiy.ads.graphs.lesson.Graph;
import com.meretskiy.ads.graphs.lesson.GraphImpl;

public class MainClass {
    public static void main(String[] args) {

        Graph graph = new GraphImpl(10);
        initGraph(graph);
        graph.bfsMinPath("Москва", "Воронеж");
    }

    private static void initGraph(Graph graph) {
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Воронеж");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Москва", "Липецк");
        graph.addEdge("Липецк", "Тула", "Воронеж");
        graph.addEdge("Воронеж", "Липецк", "Саратов", "Курск");
        graph.addEdge("Рязань", "Москва", "Тамбов");
        graph.addEdge("Тамбов", "Рязань", "Саратов");
        graph.addEdge("Саратов", "Тамбов", "Воронеж");
        graph.addEdge("Калуга", "Москва", "Орел");
        graph.addEdge("Орел", "Калуга", "Курск");
        graph.addEdge("Курск", "Орел", "Воронеж");
    }
}
