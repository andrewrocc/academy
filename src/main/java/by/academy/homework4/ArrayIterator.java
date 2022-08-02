package by.academy.homework4;

class ArrayIterator<T> {

    //region fields
    private int currentPosition = 0;

    private T[] array;

    private final short INITIAL_CAPACITY = 10;
    //endregion


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

        return array[currentPosition];
    }
}
