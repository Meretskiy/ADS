package com.meretskiy.ads.task;

import java.util.Iterator;

public class MyListIterator<E> implements Iterator<E> {

    private MyLinkedList.Node<E> current;

    public MyListIterator(MyLinkedList.Node<E> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        MyLinkedList.Node<E> temp = current;
        current = current.next;
        return (E) temp;
    }
}
