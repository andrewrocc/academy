package by.academy.homework2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        task_0();
//        task_1();
        task_2();
//        task_3();
//        task_4();
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
        ArrayList<Map<Character, Integer>> list_dic = new ArrayList<>();
        Map<Character, Integer> result = new HashMap<>();
        for (String s : input_string) {
            char[] chars_of_string = s.toCharArray();
            Map<Character, Integer> temp = getCountUniqueValues(chars_of_string, new HashMap<>());
            list_dic.add(temp);
        }
        // task solution key(chars) = max, value(repeats) = max;
        int sum_values = 0;
        int sum_keys = 0;
        int sum_vi1 = 0;
        int sum_ki1 = 0;
        int sum_res_values = 0;
        int sum_res_keys = 0;
        for (int i = 0; i < list_dic.size() - 1; i++) {
            for (var map_element : list_dic.get(i).values())
                sum_values += map_element;
            sum_keys += list_dic.get(i).size();

            for (var map_element : list_dic.get(i + 1).values())
                sum_vi1 += map_element;
            sum_ki1 += list_dic.get(i + 1).size();

            if (sum_keys < sum_ki1 && sum_values < sum_vi1) {
                sum_res_keys = sum_ki1;
                sum_res_values = sum_vi1;
                result.clear();
                result.putAll(list_dic.get(i + 1));
            }
            else {
                result.clear();
                result.putAll(list_dic.get(i));
            }


            if (list_dic.size() - 1 != i)
                sum_values = sum_keys = sum_vi1 = sum_ki1 = 0;
        }
        System.out.println(sum_res_keys + " " + sum_res_values);

        int index = list_dic.indexOf(result);
        System.out.println(input_string[index]);
    }

    public static Map<Character, Integer> getCountUniqueValues(char[] array, Map<Character, Integer> dic) {
        for (char c : array) {
            if (dic.containsKey(c))
                dic.put(c, dic.get(c) + 1);
            else
                dic.put(c, 0);
        }
        return dic;
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
        if (n > 10 || n < 1) {
            System.out.println("P7ay3r5 must be less than 11 and more than 0.");
            return;
        }
        ArrayList<List<String>> player_cards = new ArrayList<>();
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
