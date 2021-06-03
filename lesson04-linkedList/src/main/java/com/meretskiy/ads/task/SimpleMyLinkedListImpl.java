package com.meretskiy.ads.task;

import java.util.Iterator;

public class SimpleMyLinkedListImpl<E> implements MyLinkedList<E> {

    protected int size;
    protected MyLinkedList.Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        MyLinkedList.Node<E> newNode = new MyLinkedList.Node<>(value, firstElement);
        firstElement = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        MyLinkedList.Node<E> removedElement = firstElement;
        E data = removedElement.item;

        firstElement = firstElement.next;
        removedElement.next = null;
        removedElement.item = null;

        size--;
        return data;
    }

    @Override
    public boolean remove(E value) {
        MyLinkedList.Node<E> current = firstElement;
        MyLinkedList.Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        }
        else {
            previous.next = current.next;
        }

        current.next = null;
        current.item = null;

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        MyLinkedList.Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        MyLinkedList.Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("-----------");
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator<>(firstElement);
    }
}
