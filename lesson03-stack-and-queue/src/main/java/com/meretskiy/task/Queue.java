package com.meretskiy.task;

public interface Queue<E> {

    boolean insert(E value);

    E remove();

    E peekHead();

    int size();

    boolean isFull();

    default boolean isEmpty() {
        return size() == 0;
    }
}
