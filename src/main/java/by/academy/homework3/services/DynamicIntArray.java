package by.academy.homework3.services;

import java.util.Arrays;
import java.util.List;

/**
 * <p>This class is a wrapper for a standard int array (in other words, a list of primitives)</p>
 */

public class DynamicIntArray {
    //region DynamicIntArray

    //region fields
    private int[] storage;

    private int size;

    private final int INITIAL_CAPACITY = 10;
    //endregion1

    //region constr
    public DynamicIntArray() {
        storage = new int[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * <p>This class is a wrapper for a standard int array (in other words, a list of primitives).</p>
     * @param capacity the initial capacity of the list
     */
    public DynamicIntArray(int capacity) {
        storage = new int[capacity];
        size = 0;
    }
    //endregion

    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public void ensureCapacity(int min_capacity) {
        int old_capacity = storage.length;
        if (min_capacity > old_capacity) {
            int new_capacity = old_capacity + (old_capacity >> 1);
            storage = Arrays.copyOf(storage, new_capacity);         // increases array size + copy contents
        }
    }

    public int capacity() { return storage.length; }

    public int size() { return size; }

    public int[] getStorage() { return storage; }

    public boolean equals(List<Integer> list)
    {
        boolean success = (list.size() == size());
        if(success) {
            for(int idx = 0; success && (idx < size()); ++idx) {
                success = success && (get(idx) == list.get(idx).intValue());
            }
        }
        return success;
    }

    public int get(int position) {
        rangeCheck(position);
        return storage[position];
    }

    public void set(int index, int value) {
        rangeCheck(index);
        storage[index] = value;
    }

    public void add(int value) { insertAt(size, value); }                     // same as c++ std::vector push_back

    // Insert the value at the given index and shift 'tail' to give space.
    // The value can either be last position (size) or within the range 0 -> size.
    public void insertAt(int index, int value) {
        if(index < 0 || index > size)               // allows for push_back to last index also
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (capacity() < size)
            ensureCapacity(size + 1);
        int move_count = size - index;              // number of elements to shift
        if(move_count > 0)
            System.arraycopy(storage, index, storage, index + 1, move_count);

        storage[index] = value;
        size++;
    }

    public void removeAt(int index) {
        rangeCheck(index);
        int move_count = size - index - 1;
        if (move_count > 0)
            System.arraycopy(storage, index + 1, storage, index, move_count);

        size--;
    }

    public void printAll() {
        System.out.print("[ ");
        for (int idx = 0; idx < size; idx++)
            System.out.printf("%d ", get(idx));

        System.out.println("]");
    }
    //endregion
}