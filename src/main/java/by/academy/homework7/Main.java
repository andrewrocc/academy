package by.academy.homework7;

import java.util.*;
import java.time.LocalDate;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.lang.reflect.InvocationTargetException;

class Main {
    public static void main(String[] args) {
//        task_1();
        task_2();
    }

    private static void task_2() throws RuntimeException {
        try {
            Class userClass = Class.forName(User.class.getName());
            User hackUser;
            User adminUser;

//            Method[] userClassAllPublicMethods = userClass.getMethods();
//            System.out.println("Use by getMethods(): " + Arrays.toString(userClassAllPublicMethods).replace(", ", "\n"));
//
//            var meth = userClass.getMethod("getPassword", null);
//            System.out.println(meth.getName() + Arrays.toString(meth.getParameterTypes()));
//
//            Field[] userClassAllPublicFields = userClass.getFields();
//            System.out.println("Use by getFields(): " + Arrays.toString(userClassAllPublicFields).replace(", ", "\n"));
//
//            Field userClassPublicField = userClass.getField("email");
//            System.out.println(userClassPublicField);
//
//            Method[] userClassAllPrivateMethods = userClass.getDeclaredMethods();
//            System.out.println("Use by getDeclaredMethods(): " + Arrays.toString(userClassAllPrivateMethods).replace(", ", "\n"));
//
//            var private_meth = userClass.getDeclaredMethod("printUserInfo", null);
//            System.out.println(private_meth.getName() + Arrays.toString(private_meth.getParameterTypes()));
//
//            Field[] userClassPrivateFields = userClass.getDeclaredFields();
//            System.out.println("Use by getDeclaredFields(): " + Arrays.toString(userClassPrivateFields).replace(", ", "\n"));
//
//            Field userClassPrivateField = userClass.getDeclaredField("password");
//            System.out.println(userClassPrivateField);


            // set value using constructor
            Class[] params = { String.class, String.class, short.class, LocalDate.class, String.class,
                                String.class, String.class};
            hackUser = (User) userClass.getConstructor(params).newInstance("Jhon", "Doe", (short)30,
                    LocalDate.of(2000, 01, 10), "admin", "89000", "jhonDoeNameless@mail.com");

            Class aUser = Class.forName(User.class.getName());
            adminUser = (User) aUser.getConstructor().newInstance();

            Field privateFieldLogin = hackUser.getClass().getDeclaredField("login");
            privateFieldLogin.setAccessible(true);
            privateFieldLogin.set(hackUser, "admin");
            System.out.println(privateFieldLogin.get(hackUser));

            Field privateFieldPassword = hackUser.getClass().getDeclaredField("password");
            privateFieldPassword.setAccessible(true);
            privateFieldPassword.set(hackUser, "8900000");
            System.out.println(privateFieldPassword.get(hackUser));

            Field publicFieldEmail = hackUser.getClass().getField("email");
            publicFieldEmail.set(hackUser, "admin890098@mail.com");
            System.out.println(publicFieldEmail.get(hackUser));

            Method privateMethod = adminUser.getClass().getDeclaredMethod("printUserInfo");
            privateMethod.setAccessible(true);
            privateMethod.invoke(adminUser);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException
                 | InvocationTargetException | ClassNotFoundException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    private static void task_1() {
        var res = LongStream.generate(new Random()::nextInt).limit(100)
                .mapToDouble((x) -> x * Math.PI - 20).filter(x -> x < 100).sorted().skip(3)
                .boxed().collect(Collectors.toMap(Function.identity(), v -> "Number " + v));

        for (var set : res.entrySet()) {
            System.out.printf("%,.2f -> %s\n", set.getKey(), set.getValue());
        }
    }
}
