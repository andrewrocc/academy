package by.academy.homework1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        task_1();
//        task_2();
//        task_3();
//        task_4();
    }

    public static void task_1() {
        double price  = 0.0d;
        int age;
        Scanner scan = new Scanner(System.in);
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
        Scanner scan = new Scanner(System.in);
        System.out.print("Input value: ");
        String value = scan.nextLine();
        object_type parse_value = null;
        boolean isParse = false;
        boolean isUnsupported = true;

        // one of the worst codes you have ever seen
        for (int i = 0; i < object_type.values().length; i++) {
            try {
                Integer.parseInt(value);
                isParse = true;
            } catch (NumberFormatException ex) {
                isParse = false;
            }

            if (isParse){
                parse_value = object_type.Int;
                break;
            }
            else {
                parse_value = object_type.Unsupported;
                isUnsupported = false;
            }

            try {
                Double.parseDouble(value);
                isParse = true;
            } catch (NumberFormatException ex) {
                isParse = false;
            }
            if (isParse) {
                parse_value = object_type.Double;
                break;
            } else {
                parse_value = object_type.Unsupported;
                isUnsupported = false;
            }

            try {
                Float.parseFloat(value);
                isParse = true;
            } catch (NumberFormatException ex) {
                isParse = false;
            }
            if (isParse) {
                parse_value = object_type.Float;
                break;
            } else {
                parse_value = object_type.Unsupported;
                isUnsupported = false;
            }

            try {
                if (value.length() == 1)
                    isParse = true;
            } catch (NumberFormatException ex) {
                isParse = false;
            }
            if (isParse) {
                parse_value = object_type.Char;
                break;
            } else {
                parse_value = object_type.Unsupported;
                isUnsupported = false;
            }

            if (!isUnsupported && parse_value.equals(object_type.Unsupported)) {
                parse_value = object_type.String;
            }
        }

        switch (parse_value) {
            case Int:
                System.out.println("This is integer value " + Integer.parseInt(value) % 2);
                break;
            case Double:
                System.out.println("This is double value " + (Double.parseDouble(value) * 7) / 10);
                break;
            case Float:
                System.out.println("This is float value " + Float.parseFloat(value) * Float.parseFloat(value));
                break;
            case Char:
                System.out.println("This is char value " + (int) value.charAt(0));
                break;
            case String:
                System.out.println("This is string value - Hello " + value);
                break;
            default:
                System.out.println("Unsupported type!");
        }
    }

    public static void task_3() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input number (1 to 10): ");
        int value = scan.nextInt();
        if (value < 0 || value > 11)
            System.out.println("Incorrect value");
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
            System.out.print(result + " ");
            ++counter;
        }
    }
}

enum object_type {
    Int,
    Double,
    Float,
    Char,
    String,
    Unsupported;
}
