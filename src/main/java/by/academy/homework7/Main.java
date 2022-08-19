package by.academy.homework7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


class Main {
    public static void main(String[] args) {
//        task_1();
        task_2();
    }

    private static void task_2() {
        User hackUser = null;
        String userLogin = null;
        try {
            Class userClass = Class.forName(User.class.getName());
            Class[] params = { String.class, String.class, short.class, LocalDate.class, String.class,
                                String.class, String.class};
            hackUser = (User) userClass.getConstructor(params).newInstance("Jhon", "Doe", (short)30,
                    LocalDate.of(2000, 01, 10), "admin", "89000", "jhonDoeNameless@mail.com");
            Field privateField = hackUser.getClass().getDeclaredField("login");
            privateField.setAccessible(true);
            privateField.set(hackUser, "admin");
            userLogin = (String) privateField.get(hackUser);
            Method privateMethod = hackUser.getClass().getDeclaredMethod("printUserInfo");
            privateMethod.setAccessible(true);
            privateMethod.invoke(hackUser);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException
                 | InvocationTargetException | ClassNotFoundException | InstantiationException ex) {
            ex.printStackTrace();
        }
        System.out.println(userLogin);
    }

    private static void task_1() {
        var res = LongStream.generate(new Random()::nextInt).limit(100)
                .mapToDouble((x) -> x * Math.PI - 20).filter(x -> x < 100).sorted().skip(3)
                .boxed().collect(Collectors.toMap(Function.identity(), v -> "Number " + v));

        DecimalFormat doubleValues = new DecimalFormat("#.##");
        for (var set : res.entrySet()) {
            System.out.println(doubleValues.format(set.getKey()) + " = " + set.getValue());
        }
    }
}
