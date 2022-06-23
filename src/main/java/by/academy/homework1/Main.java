package by.academy.homework1;

import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
//        task_1();
//        task_2();
        task_3();
//        task_4();
        scan.close();
    }

    public static void task_1() {
        double price  = 0.0d;
        int age;
        System.out.print("Input price(use only ',' as separator): ");
        price = scan.nextDouble();
        System.out.print("Input you age: ");
        age = scan.nextInt();
        scan.close();
        if (price < 0)
            System.out.println("Incorrect value, price can not be negative.");
        else if (price < 100)
            System.out.printf("Total price including discount: %.2f%n", (price - (price * 5) / 100));
        else if (price >= 100 && price < 200)
            System.out.printf("Total price including discount: %.2f%n", (price - (price * 7) / 100));
        else if (price >= 200 && price < 300 && age > 18)
            System.out.printf("Total price including discount: %.2f%n", (price - (price * 16) / 100));
        else if (price >= 200 && price < 300 && age <= 18)
            System.out.printf("Total price including discount: %.2f%n", (price - (price * 9) / 100));
        else if (price >= 300 && price < 400)
            System.out.printf("Total price including discount: %.2f%n ", (price - (price * 15) / 100));
        else if (price >= 400)
            System.out.printf("Total price including discount: %.2f%n", (price - (price * 20) / 100));
        System.out.println("test");
    }

    public static void task_2() {
        System.out.print("Input the value and value of type (use space as separator or _): ");
        String value = scan.nextLine();
        String[] result_parse = value.split("[ _]+");

        String result = switch(result_parse[1].substring(0, 1).toUpperCase() + result_parse[1].substring(1)) {
            case "Int" -> "This is integer value " + Integer.parseInt(result_parse[0]) % 2;
            case "Double" -> "This is double value " + (Double.parseDouble(result_parse[0]) * 7) / 10;
            case "Float" -> "This is float value " + Float.parseFloat(result_parse[0]) * Float.parseFloat(result_parse[0]);
            case "Char" -> "This is char value " + (int) result_parse[0].charAt(0);
            case "String" -> "This is string value - Hello " + result_parse[0];
            default -> "Unsupported type!";
        };
        System.out.println(result);
    }

    public static void task_3() {
        System.out.print("Input number (1 to 10): ");
        int value = scan.nextInt();
        if (value <= 0 || value > 10) {
            System.out.println("Incorrect value");
            return;
        }
        for (int i = 1; i < 11; i++) {
            System.out.println(i + " * " + value + " = " + i * value);
        }
    }

    public static void task_4() {
        int upper_bound = 1_000_000;
        int result = 1;
        int counter = 1;
        while (result < upper_bound) {
            result = (int) Math.pow(2, counter);
            if (result < upper_bound) {
                System.out.print(result + " ");
                ++counter;
            }
        }
    }
}
