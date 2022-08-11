package by.academy.homework4;

import java.util.Collection;

public class ArrayIterator<T> {

    private int currentPosition = 0;

    private T[] array;

    public ArrayIterator() { super(); }

    public ArrayIterator(T[] array) {
         this.array = array;
    }

    public boolean hasNext() {
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
