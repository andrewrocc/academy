package by.academy.homework3.services;

import by.academy.homework3.model.Product;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListProduct implements Serializable {

    @Serial
    private static final long serialVersionUID = 001010L;

    //region fields
    private Product[] storage;

    private transient int size;

    private transient final int INITIAL_CAPACITY = 10;
    //endregion1

    //region constr
    public ListProduct() {
        storage = new Product[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * <p>This class is a wrapper for a standard int array (in other words, a list of primitives).</p>
     * @param capacity the initial capacity of the list
     */
    public ListProduct(int capacity) {
        storage = new Product[capacity];
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

    public void refreshSize() {
        for (var e : storage) {
            if (e != null)
                size++;
        }
    }

    public int size() { return size; }

    public Product[] getStorage() { return storage; }

    public Product get(int position) {
        rangeCheck(position);
        return storage[position];
    }

    public void set(int index, Product value) {
        rangeCheck(index);
        storage[index] = value;
    }

    public void add(Product value) { insertAt(size, value); }

    public void insertAt(int index, Product value) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (capacity() <= size)
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

    public boolean remove(Object o) {
        int i = 0;
        if (o == null) {
            return false;
        } else {
            for (; i < size; i++)
                if (o.equals(storage[i]))
                    break;
        }
        removeAt(i);
        return true;
    }

    @Override
    public String toString() {
        return "{ " +
                Arrays.deepToString(storage).replace("},", "}\n") +
                " }";
    }

    public boolean equals(List<Product> list)
    {
        boolean success = (list.size() == size());
        if(success) {
            for(int idx = 0; success && (idx < size()); ++idx) {
                success = success && (get(idx) == list.get(idx));
            }
        }
        return success;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, INITIAL_CAPACITY);
        result = 31 * result + Arrays.hashCode(storage);
        return result;
    }
}
