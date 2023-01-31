package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> compared;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        compared = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }
        T maxItem = (T) get(0);
        for (int i = 0; i < size(); i += 1) {
            if (compared.compare((T) get(i), maxItem) > 0) {
                maxItem = (T) get(i);
            }
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T maxItem = (T) get(0);
        for (int i = 0; i < size(); i += 1) {
            if (c.compare((T) get(i), maxItem) > 0) {
                maxItem = (T) get(i);
            }
        }
        return maxItem;
    }
}
