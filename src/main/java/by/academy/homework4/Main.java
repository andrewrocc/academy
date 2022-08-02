package by.academy.homework4;

public class Main {
    public static void main(String[] args) {
        //task_3
        DynamicArrayT<Integer> a = new DynamicArrayT<>(10);
        a.add(5);
        a.add(1);
        a.add(8);
        a.add(2);
        a.add(9);
        a.add(6);
        a.add(3);
        a.add(7);
        System.out.println(a);
        System.out.println("1st element: " + a.getFirst());
        a.removeAt(7);
        System.out.println(a);
        System.out.println("Last element: " + a.getLast());
        a.remove(8);
        System.out.println(a);
        System.out.println("Last not null element index: " + a.getLastElementIndex());

        // task_4
        ArrayIterator<Integer> iterator = new ArrayIterator<>(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }
}
