package by.academy.homework8;

import by.academy.homework8.model.*;
import by.academy.homework8.service.FileIOService;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

class Main {

    public static ArrayList<Plane> planePark = new ArrayList<>();

    private static final String PATH = Paths.get("").toAbsolutePath().toString().concat("\\planesData.xml");


    static {
        FileIOService fileService = new FileIOService(PATH);
        try {
            fileService.saveData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            planePark = fileService.loadData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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