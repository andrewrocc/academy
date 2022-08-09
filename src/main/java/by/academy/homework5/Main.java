package by.academy.homework5;

import by.academy.benchmark.BenchmarkRunning;

import java.util.*;

class Main {

    public static void main(String[] args) {
        //task 1
//        System.out.println(task_1(new ArrayList<>(List.of(1, 1, 1, 2, 3, 4, 4, 4, 5, 6, 7, 0, 0, 8))));

        //task 2
        task_2();
    }

    public static HashSet task_1(Collection<?> collection) {
        return new HashSet<>(collection);
    }

    public static void task_2() {
        try {
            BenchmarkRunning.main(new String[] {""});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
