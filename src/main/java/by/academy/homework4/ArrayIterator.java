package by.academy.homework4;

import java.net.CookieHandler;
import java.util.Collection;

class ArrayIterator<T> {

    //region fields
    private int currentPosition = 0;

    private T[] array;

    private final short INITIAL_CAPACITY = 10;
    //endregion

    public ArrayIterator() { super(); }

    public ArrayIterator(T[] array) {
         this.array = array;
    }

    private void preLoad() {
        if (array.length == 0) {
            array = (T[]) new Object[INITIAL_CAPACITY];
        }
    }

    public boolean hasNext() {
        preLoad();
        return currentPosition < array.length;
    }

    public T next() {
        if (!hasNext()) {
            return null;
        }
        return array[currentPosition++];
    }

    public ArrayIterator<T> iterator(Collection<?> value) {
        T[] array = (T[]) value.toArray();
        return new ArrayIterator<>(array);
    }
}
