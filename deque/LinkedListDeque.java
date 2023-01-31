package deque;

/**
 * @source: Lab3 SLList
 */

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size = size + 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node s = new Node(sentinel.item, sentinel.prev, sentinel.next);
        while (s != sentinel) {
            s = s.next;
            System.out.print(s.item + " ");
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T i = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size = size - 1;
            return i;
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T i = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size = size - 1;
            return i;
        }
    }

    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        } else {
            Node s = sentinel.next;
            for (int i = 0; i < index; i += 1) {
                s = s.next;
            }
            return s.item;
        }
    }

    public T getRecursive(int index) {
        Node s = sentinel.next;
        if (index >= size) {
            return null;
        }
        return helperRecursive(index, s);
    }

    private T helperRecursive(int index, Node s) {
        if (index == 0) {
            return s.item;
        }
        return helperRecursive(index - 1, s.next);
    }

    public Iterator<T> iterator() {
        return new LinkedListDeque.LinkListIterator();
    }

    private class LinkListIterator implements Iterator<T> {
        private int lPos;

        public LinkListIterator() {
            lPos = 0;
        }

        public boolean hasNext() {
            return lPos < size;
        }

        public T next() {
            T returnItem = get(lPos);
            lPos += 1;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Deque OtherSet) {
            // check sets are of the same size
            if (OtherSet.size() != this.size) {
                return false;
            }
            for (int i = 0; i < size; i += 1) {
                if (!((Deque<T>) o).get(i).equals(get(i))) {
                    return false;
                }
            }
            return true;
        }
        // o is not an arrayset, so return false
        return false;
    }
}

