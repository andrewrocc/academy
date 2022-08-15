package by.academy.homework4;

public class ArrayIterator<T> {

    private int currentPosition = 0;

    private T[] array;

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

    public ArrayIterator<T> iterator() {
        return new ArrayIterator<>(array);
    }
}
