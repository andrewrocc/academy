package by.academy.homework2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        task_0();
//        task_1();
//        task_2();         // do not work
//        task_3();
        task_4();
        scan.close();
    }

    public static void task_0() {
        String[] input_value = scan.nextLine().split(" ");
        int array_size = Integer.parseInt(input_value[0]);
        int target_value = Integer.parseInt(input_value[1]);
        int[] array = new int[array_size];
        String[] str_array_items = scan.nextLine().split(" ");

        for(int i = 0; i < array_size; i++) {
            array[i] = Integer.parseInt(str_array_items[i]);
            System.out.print(array[i] + " ");
        }

        System.out.println("Number of pairs " + pairs(target_value, array));
    }
    private static int pairs(int target_value, int[] array) {
        int pairsCount = 0;
        if (target_value > 0)
            array = Arrays.stream(array).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        else if (target_value == 0)
            return 0;
        else
            Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            for (int k = i + 1; k < array.length; k++) {
                if ((array[i] - array[k]) == target_value)
                    pairsCount++;
            }
        }
        return  pairsCount;
    }

    public static void task_1() {
        String string_one = scan.nextLine();
        String string_two = scan.nextLine();
        if (string_one.length() != string_two.length()) {
            System.out.println("false");
            return;
        }
        ArrayList<Character> list_string_one = new ArrayList<>(string_one.chars().mapToObj(c -> (char) c).toList());
        ArrayList<Character> list_string_two = new ArrayList<>(string_two.chars().mapToObj(c -> (char) c).toList());
        int k;
        for (int i = 0; i < string_one.length(); i++) {
            k = i;
            if (k > list_string_one.size())
                k = 0;
            char del_char = list_string_two.get(k);
            if (list_string_one.contains(del_char)) {
                list_string_two.remove(Character.valueOf(del_char));
                list_string_one.remove(Character.valueOf(del_char));
            }
            else
                break;
        }

        System.out.println(list_string_one.isEmpty() && list_string_two.isEmpty());
    }

    public static void task_2() {
        String[] input_string = scan.nextLine().split(" ");
        String result = "";
        int repeat_counter = 0;
        for (int i = 0; i < input_string.length; i++) {
            char value = input_string[i].charAt(i);
            for (int j = 0; j < input_string[i].length(); j++) {
                if (value == input_string[i].charAt(j))
                    repeat_counter++;
            }
        }

        System.out.println(--repeat_counter);
    }

    public static void task_3() {
        String[] input_string = scan.nextLine().split(" ");
        System.out.println(input_string[0].substring(0, input_string[0].length() / 2) + input_string[1].substring(input_string[1].length() / 2, input_string[1].length()));
    }

    public static void task_4() {
        String[] deck = { "A♣", "2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣",
                        "A♦", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦",
                        "A❤", "2❤", "3❤", "4❤", "5❤", "6❤", "7❤", "8❤", "9❤", "10❤", "J❤", "Q❤", "K❤",
                        "A♠", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠" };
        ArrayList<String> list_deck = Arrays.stream(deck).collect(Collectors.toCollection(ArrayList::new));
        System.out.print("Input the number of players: ");
        int n = scan.nextInt();
        ArrayList<List<String>> player_cards = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (int k = 0; k < 5; k++) {
                var e = list_deck.get(new Random().nextInt(list_deck.size()));
                temp.add(e);
                list_deck.remove(e);
            }
            player_cards.add(temp);
        }

        for (var e : player_cards){
            for (var q : e)
                System.out.print(q + " ");
            System.out.println();
        }
        System.out.println("Total card in deck = " + deck.length + ". The cards left in the deck: " + (deck.length - player_cards.size() * 5));
    }
}
