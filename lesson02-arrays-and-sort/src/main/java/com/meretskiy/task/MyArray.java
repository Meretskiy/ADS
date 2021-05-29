package com.meretskiy.task;

public interface MyArray<E> {

    void add(E value);

    E get(int index);

    boolean remove(E value);
    E remove(int index);

    int indexOf(E value);

    default boolean contains(E value) {
        return indexOf(value) != -1;
    }

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    void display();

    void sortBubble();
    void sortSelect();
    void sortInsert();

    MyArray<E> copy();
}

