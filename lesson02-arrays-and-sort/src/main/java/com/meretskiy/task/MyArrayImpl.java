package com.meretskiy.task;

import java.util.Arrays;

public class MyArrayImpl<E extends Comparable<? super E>> implements MyArray<E> {

    protected E[] data;
    protected int size;

    public MyArrayImpl(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    private void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, size * 2);
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new MyArrayIndexOutOfBoundsException(index, size);
        }
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && remove(index) != null;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return removedValue;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "MyArrayImpl{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int indexA, int indexB) {
        E temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int index = i;
            while (index > 0 && data[index - 1].compareTo(temp) >= 0) {
                data[index] = data[index - 1];
                index--;
            }
            data[index] = temp;
        }
    }

    @Override
    public MyArray<E> copy() {
        MyArrayImpl<E> newArray = new MyArrayImpl<>(size);
        newArray.size = size;
        newArray.data = Arrays.copyOf(this.data, size);
        return newArray;
    }
}
