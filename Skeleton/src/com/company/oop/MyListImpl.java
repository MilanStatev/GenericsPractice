package com.company.oop;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyListImpl<T> implements MyList<T> {

    private static final int INITIAL_CAPACITY = 4;

    private T[] internalArray;
    private int size;

    public MyListImpl() {
        this(INITIAL_CAPACITY);
    }

    public MyListImpl(int capacity) {
        internalArray = (T[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return internalArray.length;
    }

    @Override
    public void add(T element) {
        if (size == internalArray.length) {
            internalArray = Arrays.copyOf(internalArray, capacity() * 2);
        }

        internalArray[size] = element;
        size++;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return internalArray[index];
    }


    @Override
    public int indexOf(T element) {
        for (int index = 0; index < size; index++) {
            if (internalArray[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T element) {
        for (int index = size - 1; index >= 0; index--) {
            if (internalArray[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T element) {
        for (T object : internalArray) {
            if (element.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeAt(int index) {
        validateIndex(index);
        T[] temp = (T[]) new Object[size - 1];

        System.arraycopy(internalArray, 0, temp,0,index);
        System.arraycopy(internalArray, index + 1, temp, index, size - 1 - index);

        internalArray = Arrays.copyOf(temp, temp.length);
        size--;
    }

    @Override
    public boolean remove(T element) {
        if (!contains(element)) {
            return false;
        }

        int index = indexOf(element);
        removeAt(index);

        return true;
    }

    @Override
    public void clear() {
        internalArray = (T[]) new Object[size];
        size = 0;
    }

    @Override
    public void swap(int from, int to) {
        validateIndex(from);
        validateIndex(to);

        T swappedFrom = internalArray[from];

        internalArray[from] = internalArray[to];
        internalArray[to] = swappedFrom;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("[");
        while (iterator().hasNext()) {
            sb.append(iterator().next());
            if (iterator().hasNext()){
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    private void validateIndex(int index) {
        if (index == size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index, provide index between 0 and array.length - 1");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyListImpl<?> myList = (MyListImpl<?>) o;
        return size == myList.size && Arrays.equals(internalArray, myList.internalArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(internalArray);
        return result;
    }

    private class MyListIterator implements Iterator<T> {
        private static int counter = 0;


        @Override
        public boolean hasNext() {
            return counter < size;
        }

        @Override
        public T next() {
            T element = internalArray[counter];
            counter++;
            return element;
        }
    }
}
