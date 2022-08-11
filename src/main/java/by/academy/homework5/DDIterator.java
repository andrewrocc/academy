package by.academy.homework5;

import java.util.Iterator;

/**
* <p>DDIterator - double dimension iterator
* */
class DDIterator<T> implements Iterator<T> {

    // CPDD_I - current position double dimension i index
    // CPDD_J - current position double dimension j index
    private int CPDD_I, CPDD_J;

    private T[][] storage;

    public DDIterator(T[][] storage) {
        this.storage = storage;
    }

    @Override
    public boolean hasNext() {
        return CPDD_I < storage.length
                && CPDD_J < storage[CPDD_I].length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        T nextValue = storage[CPDD_I][CPDD_J++];
        if (CPDD_J >= storage[CPDD_I].length) {
            CPDD_I++;
            CPDD_J = 0;
        }
        return nextValue;
    }
}
