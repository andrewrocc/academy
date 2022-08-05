package by.academy.homework4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String DATE_PATTERN_FORMAT2 = "(0[1-9]|1\\d|2\\d|3[0-1]|[1-9])-(0[1-9]|1[0-2]|[1-9])-(\\d{4})";
    public static void main(String[] args) {
        //task_1
        CustomDate cDate = new CustomDate(2028, 8, 1);
        cDate.getDayOfWeek();
        CustomDate d = new CustomDate(2020, 8, 1);
        System.out.println(cDate.getNumberOfDays(cDate, d));
        System.out.println(cDate.isLeapYear());
        Scanner scan = new Scanner(System.in);
        String dateString;
        boolean isValidDate;
        do {
            System.out.print("Enter the date(dd-mm-yyyy) : ");
            dateString = scan.nextLine();
            isValidDate = validateDate(dateString);
        } while(!isValidDate);
        CustomDate customDate_stringFormat = new CustomDate(dateString);
        System.out.println(customDate_stringFormat);

        //task_2
        Body test_android_0001 = new Body();
        test_android_0001.live();

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
        ArrayList<String> aList = new ArrayList<String>(Arrays.asList("one", "tow", "three", "four", "five"));
        ArrayIterator<Integer> aIterator = new ArrayIterator<>();
        ArrayIterator<Integer> iterator = aIterator.iterator(aList);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    public static boolean validateDate(String dateString) {
        return dateString.matches(DATE_PATTERN_FORMAT2);
    }
}
