package deque;

import java.util.Iterator;

/**
 * @source: Lab3 AList, LectureCode-fa22 lec7, lec11
 */

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int nextFirst;
    private int nextLast;
    private int size;
    private T[] items;

    private final int numF = 5;
    private final int numL = 6;
    private final int numSize = 16;
    private final int oCapacity = 8;

    public ArrayDeque() {
        items = (T[]) new Object[oCapacity];
        nextFirst = numF;
        nextLast = numL;
        size = 0;
    }

    private int minusOne(int index) {
        if (index - 1 < 0) {
            return items.length - 1;
        }
        return index - 1;
    }

    private int plusOne(int index) {
        if (index == items.length - 1) {
            index = 0;
        } else {
            index = index + 1;
        }
        return index;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i += 1) {
            a[i] = get(i);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        size = size + 1;
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        size = size + 1;
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[i] + " ");
        }
    }

    private void sizeBound() {
        double l = (double) size / (double) items.length;
        if (l < 0.25 && items.length >= numSize) {
            resize(items.length / 2);
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = plusOne(nextFirst);
        T r = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        sizeBound();
        return r;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T r = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        sizeBound();
        return r;
    }

    @Override
    public T get(int index) {
        if (index > size || index < 0) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int wPos;

        public ArrayIterator() {
            wPos = 0;
        }

        public boolean hasNext() {
            return wPos < size;
        }

        public T next() {
            T returnItem = get(wPos);
            wPos += 1;
            return returnItem;
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Deque) {
            // check sets are of the same size
            if (((Deque) o).size() != this.size) {
                return false;
            }
            for (int i = 0; i < size; i += 1) {
                // check that all of MY items are in the other array set
                if (!((Deque<T>) o).get(i).equals(get(i))) {
                    return false;
                }
                if (((Deque<T>) o).get(i) == null || get(i) == null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
