package com.meretskiy.task;

public class MyArrayIndexOutOfBoundsException extends RuntimeException {
    public MyArrayIndexOutOfBoundsException(int index, int size) {
        super(String.format("Invalid index %s for array with length %s", index, size));
    }
}
