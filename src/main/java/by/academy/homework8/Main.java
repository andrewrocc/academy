package by.academy.homework8;

import by.academy.homework8.model.*;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
//        task_1();
        task_2();
    }

    /*2) Авиакомпания. Определить иерархию самолетов. Создать авиакомпанию.
        Посчитать общую вместимость и грузоподъемность. Провести сортировку самолетов
        компании по дальности полета. Найти самолет в компании, соответствующий заданному
        диапазону параметров потребления горючего.

        Использовать возможности ООП. */
    public static void task_2() {
        PassengerPlane airbusA320 = new PassengerPlane("Airbus", "A320", "20150510_A4532", 4010.0, 2400, 8510.50, 180);
        PassengerPlane boeing777 = new PassengerPlane("Boeing", "777", "12122010-MB2314", 9100.0,  6100.0, 15_660.0, 400);
        WideBodyPlane airbusA350 = new WideBodyPlane("Airbus", "A350-1000", "10022005T35656G", 16100.0, 5800.0, 480);
        CargoPlane airbus380 = new CargoPlane("Airbus", "380", "23102012-23K04RK", 15_400.0, 4670.0, 560_000);
        ArrayList<Plane> planePark = new ArrayList<>();
        planePark.add(airbusA320);
        planePark.add(boeing777);
        planePark.add(airbusA350);
        planePark.add(airbus380);
        Airline emirates = new Airline("Fly Emirates", planePark);
        System.out.println(emirates);
        System.out.println(emirates.getPlaneByFuelConsumption(4000, 6000));
        emirates.getTotalCargoPassengerCapacity();
        emirates.sortPlanesByRange();
        System.out.println(emirates);
    }

    /*1) Реализуйте метод для выполнения простейшего сжатия строк с использованием счетчика повторяющихся символов.
        Например, строка ааbсссссааа превращается в а2b1с5а3.
        Если сжатая строка не становится короче исходной,
        то метод возвращает исходную строку. Предполагается, что строка состоит
        только из букв верхнего и нижнего регистра (a-z).*/
    public static void task_1() {
        String strInput = "aabcccccaaa";
        ArrayList<Character> listCharacter = new ArrayList<>();
        ArrayList<Integer> listCounter = new ArrayList<>();
        int counter = 1;
        char currentLetter = strInput.charAt(0);
        for (int i = 1; i < strInput.length(); i++) {
            if (currentLetter == strInput.charAt(i)) {

                if (!listCharacter.isEmpty()) {
                    listCounter.set(listCharacter.size() - 1, ++counter);
                } else {
                    listCharacter.add(currentLetter);
                    listCounter.add(++counter);
                }

            } else {
                counter = 1;
                currentLetter = strInput.charAt(i);
                listCharacter.add(currentLetter);
                listCounter.add(counter);
            }
        }

        var isCompressed = listCounter.stream().anyMatch(x -> x > 1);
        if (isCompressed) {
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < listCharacter.size(); i++) {
                result.add(listCharacter.get(i) + "" + listCounter.get(i));
            }
            System.out.println(result);
        } else {
            System.out.println(strInput);
        }

    }
}