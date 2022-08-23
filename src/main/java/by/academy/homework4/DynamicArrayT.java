package by.academy.homework4;

import java.util.Arrays;

class DynamicArrayT<T> {

    private T[] storage;

    private int size;

    private final int INITIAL_CAPACITY = 16;

    public DynamicArrayT() {
        storage = (T[])new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public DynamicArrayT(int capacity) {
        storage = (T[])new Object[capacity];
        size = 0;
    }

    private int capacity() { return storage.length; }

    public int size() { return size; }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public void add(T value) {
        insertAt(size, value);
    }

    public void insertAt(int index, T value) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (capacity() < size)
            ensureCapacity(size + 1);
        int moveCount = size - index;
        if(moveCount > 0)
            System.arraycopy(storage, index, storage, index + 1, moveCount);

        storage[index] = value;
        size++;
    }

    public void ensureCapacity(int min_capacity) {
        int old_capacity = storage.length;
        if (min_capacity > old_capacity) {
            int new_capacity = old_capacity + (old_capacity >> 1);
            storage = Arrays.copyOf(storage, new_capacity);
        }
    }

    public T get(int index) {
        rangeCheck(index);
        return storage[index];
    }

    public T getLast() { return storage[size - 1]; }

    public T getFirst() { return storage[0]; }

    public int getLastElementIndex() { return size(); }

    public void removeAt(int index) {
        rangeCheck(index);
        final int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(storage, index + 1, storage, index, newSize - 1);
        }
        storage[size = newSize] = null;
    }

    public boolean remove(T value) {
        int i = 0;
        if (value == null) {
            return false;
        } else {
            for (; i < size; i++)
                if (value.equals(storage[i]))
                    break;
        }
        removeAt(i);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[ ");
        for (var e : storage) {
            if (e != null) {
                sBuilder.append(e + ", ");
            }
        }
        sBuilder.replace(sBuilder.length() - 2, sBuilder.length(), "");
        sBuilder.append(" ]");
        return sBuilder.toString();
    }
}
