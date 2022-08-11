package by.academy.homework5;

import by.academy.benchmark.BenchmarkRunning;
import java.io.IOException;
import java.util.*;

class Main {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //task 1
//        System.out.println(task_1(new ArrayList<>(List.of(1, 1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 0, 0, 8))));

        task_2();

//        task_3();

//        task_4();

//        task_5();

//        task_6();

//        task_7();
    }

    public static void task_7() {
        DoublyLinkedListLib.DoublyLinkedList list = new DoublyLinkedListLib.DoublyLinkedList();
        System.out.print("Input number of list elements: ");
        int listCount = scan.nextInt();
        scan.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?");
        for(int i = 0; i < listCount; i++) {
            int listItem = scan.nextInt();
            scan.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?");
            list.insertNode(listItem);
        }
        DoublyLinkedListLib.DoublyLinkedList reversedList = DoublyLinkedListLib.reverse(list);

        try {
            DoublyLinkedListLib.printDoublyLinkedList(reversedList, " ");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            scan.close();
        }
    }

    public static void task_6() {
        short[] smallArray = new short[8];
        try {
            for (short i = 0; i < 10; i++) {
                smallArray[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Array is to small, expand the array\n" + ex.getMessage());
        }
    }

    public static void task_5() {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor " +
                "in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.";
        Map<Character, Integer> frequencyDictionary = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char iCharacter = text.charAt(i);
            if (frequencyDictionary.containsKey(iCharacter)) {
                frequencyDictionary.put(iCharacter, frequencyDictionary.get(iCharacter) + 1);
            } else {
                frequencyDictionary.put(iCharacter, 1);
            }
        }

        for (var set : frequencyDictionary.entrySet()) {
            System.out.println(set.getKey() + " - " + set.getValue());
        }
    }

    public static void task_4() {
        List<Integer> studentsMarksList = Arrays.stream(new Random().ints(20, 1,10).toArray()).boxed().toList();
        ArrayList<Integer> studentsMarks = new ArrayList<>(studentsMarksList);
        System.out.println(studentsMarks);
//        System.out.println(studentsMarks.stream().max(Integer::compare).get());
        Iterator<Integer> marksIterator = studentsMarks.iterator();
        int maxMark = 0;
        while (marksIterator.hasNext()) {
            int currentValue = marksIterator.next();
            if (maxMark < currentValue) {
                maxMark = currentValue;
            }
        }
        System.out.println(maxMark);
    }

    public static void task_3() {
        Integer[][] array = { { 4, 2, 1, 3 }, { 8, 6, 5, 7 }, { 9, 0, 10, 11 }, { 13, 12, 14, 15 }};
        DDIterator dIterator = new DDIterator(array);
        while (dIterator.hasNext()) {
            System.out.print(dIterator.next() + " ");
        }
    }

    public static void task_2() {
        try {
            BenchmarkRunning.main(new String[] {""});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static HashSet task_1(Collection<?> collection) {
        return new HashSet<>(collection);
    }
}
