package by.academy.homework3;

import by.academy.homework3.model.*;
import by.academy.homework3.services.*;
import by.academy.homework3.services.Serializer.FileIOServise;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static final Scanner scan = new Scanner(System.in);

    private static final String fileName = "data.json";

    private static final Path currentRelativePath = Paths.get("");

    private static final String currentDirectory = currentRelativePath.toAbsolutePath().toString().concat("\\" + fileName);

    public static void main(String[] args) {

        User seller = null;
        User buyer = null;
        do {
            seller = sellerInfo();
            if (seller == null) {
                System.out.println("The seller information needs to be corrected!!!\n");
                continue;
            }

            buyer = buyerInfo();
            if (buyer == null) {
                System.out.println("The buyer information needs to be corrected");
            }
        } while (seller == null && buyer == null);

        char isExit = 'n';
        ListProduct listProduct;
        Deal deal;
        do {
            int pointMenu = mainMenu();
            listProduct = new ListProduct();

            switch (pointMenu) {
                case 1: shopMenu();
                case 2: shopMenu();
                case 3: shopMenu();
                case 4: break;
                default:
            }

            System.out.print("Do you want to get out?(y/n): ");
            isExit = scan.nextLine().charAt(0);
        } while(isExit == 'n');

//        User a = User.isValidDataFormat("an", 123.2, LocalDate.parse("08-01-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "wergf@gmai.com", "+375334560099");
//        System.out.println(a);

        scan.close();
    }

    public static int mainMenu() {
        System.out.println("1. Shop menu\n2. Buy\n3. Basket\n4. Exit");
        return scan.nextInt();
    }

    public static int shopMenu() {
        System.out.println();
        return 1;
    }

    public static User sellerInfo() {
        String userName, userEmail, userPhone;
        double userMoney;
        LocalDate dateOfBirth;
        System.out.print("Enter the seller name: ");
        userName = scan.nextLine();
        System.out.print("Enter the seller email: ");
        userEmail = scan.nextLine();
        System.out.print("Enter the seller phone(+357...): ");
        userPhone = scan.nextLine();
        System.out.print("Enter the seller money: ");
        userMoney = scan.nextDouble();
        System.out.print("Enter the seller date of birth: ");
        String dateString = scan.nextLine();
        dateString = scan.nextLine();
        dateOfBirth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return User.isValidDataFormat(userName, userMoney, dateOfBirth, userEmail, userPhone);
    }

    public static User buyerInfo() {
        String userName, userEmail, userPhone;
        double userMoney;
        LocalDate dateOfBirth;
        System.out.print("Enter the buyer name: ");
        userName = scan.nextLine();
        System.out.print("Enter the buyer email: ");
        userEmail = scan.nextLine();
        System.out.print("Enter the buyer phone(+357...): ");
        userPhone = scan.nextLine();
        System.out.print("Enter the buyer money: ");
        userMoney = scan.nextDouble();
        System.out.print("Enter the buyer date of birth: ");
        String dateString = scan.nextLine();
        dateString = scan.nextLine();
        dateOfBirth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return User.isValidDataFormat(userName, userMoney, dateOfBirth, userEmail, userPhone);
    }

    private static void task_8() {
//        System.out.print("Enter user name: ");
//        String userName = scan.nextLine();
//        System.out.print("Enter user phone: ");
//        String phone = scan.nextLine();
//        System.out.print("Enter user email: ");
//        String email = scan.nextLine();
//        String[] bDate = task_3();
//
//        if (Boolean.valueOf(bDate[1]).equals(true)) {
//            User user = new User(userName, bDate[0], phone, email);
//            if (user.getPhone() != null || user.getEmail() != null) {
//                System.out.println(user);
//            }
//        }
//        else {
//            System.out.println("Incorrect date.");
//        }
    }

    private static void task_6() {
        FileIOServise ioServise = new FileIOServise(currentDirectory);

        // serialise data (save data)
        ListProduct listToFile = new ListProduct();
        listToFile.add(new Milks("Milk", 15.5, (short) 2, 0.3, true, 5.1));
        listToFile.add(new Meats("Chicken", 26.99, (short) 1, 0.3, true, 3.23));
        listToFile.add(new Milks("Cheese", 45.0, (short) 1, 0.3, true, 0.561));
        listToFile.add(new Milks("Ice-cream", 9.99, (short) 4, 0.3, true, 6.98));
        listToFile.add(new Meats("Pizza", 31.95, (short) 3, 0.3, true, 3.56));
        listToFile.add(new Drinks("Coke", 7.0, (short) 2, 0.3, true, 2.1));
        ioServise.saveData(listToFile);

        // deserialize data(load data)
        Object list = ioServise.loadData();
        System.out.println(list.toString().replace("},", "}\n"));

        // Menu
//        char response = 'y';
//        do {
//
//
//
//            System.out.println("Do you want to end it?(y/n): ");
//            response = scan.nextLine().charAt(0);
//        } while (response == 'y');
    }

    private static void task_5() {
        // Examples:
        //  +111 (202) 555-0125, +111 202 555 0125, +1112025550125, +111 202-555-0125, +211 (202) 555-0125, (202) 555-0125, 202-555-0125, +375 (29) 623 15 64, +375 29 623-15-64, +375296231564, +375 29 623 15 64, 623 15 64, 6231564
        System.out.print("Enter one or more numbers(separated by commas ', '): ");
        String[] phone_number = scan.nextLine().split(", ");
        AmericanPhoneValidator phoneValidator = new AmericanPhoneValidator();
        System.out.println("American phone validator:");
        for (var e : phone_number) {
            System.out.println((e.length() < 17 ? e + "\t\t\t" : e + "\t\t") + (phoneValidator.validate(e) ? "valid" : "not valid"));
        }

        System.out.println("----------------------------------------");

        System.out.println("Belarus phone validator:");
        BelarusPhoneValidator phoneValidator_BLR = new BelarusPhoneValidator();
        for (var e : phone_number) {
            System.out.println((e.length() < 17 ? e + "\t\t\t" : e + "\t\t") + (phoneValidator_BLR.validate(e) ? "valid" : "not valid"));
        }

        System.out.println("----------------------------------------");

        // Examples:
        // username@domain.com, user.name@lol.com, asldkj34@gmail.com, daink_2055@mail.ru, 123411235@qweqwr, 123123123@, n1@gmail.blr, google@.com, q123a_q234e.@mail.ru
        System.out.print("Enter emails (separated by commas ', '): ");
        String[] emails = scan.nextLine().split(", ");
        EmailValidator e_validator = new EmailValidator();
        System.out.println("Email validator:");
        for (var e :emails) {
            System.out.println((e.length() < 15 ? e + "\t\t\t" : e + "\t\t") + (e_validator.validate(e) ? "valid" : "not valid"));
        }
    }

    private static void task_4(){
        String user_date = scan.nextLine();
        byte isException_b = 0b001;
        if (user_date.length() != 10) {
            System.out.println("Incorrect date");
            return;
        }

        String[] patternsDateFormat = { "dd/MM/yyyy", "dd-MM-yyyy", "dd.MM.yyyy" };
        for (int i = 0; i < patternsDateFormat.length; i++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternsDateFormat[i]);
            try {
                Date date = simpleDateFormat.parse(user_date);
                printDate(simpleDateFormat, date);
                break;
            } catch (ParseException ex) {
                isException_b <<= 1;
            }
        }

        System.out.println(((isException_b ^ 0b1000) == 0) ? "Incorrect date" : null);
    }

    private static void printDate(SimpleDateFormat simpleFormat, Date date) {
        simpleFormat.applyPattern("dd");
        System.out.println("Day: " + simpleFormat.format(date));
        simpleFormat.applyPattern("MM");
        System.out.println("Month: " + simpleFormat.format(date));
        simpleFormat.applyPattern("yyyy");
        System.out.println("Year: " + simpleFormat.format(date));
    }

//    private static String[] task_3() {
//        System.out.print("Enter the date format(dd/mm/yyyy) or (dd-mm-yyyy): ");
//        String date = scan.nextLine();
//        boolean res_opt1 = date.matches(DATE_PATTERN);
//        boolean res_opt2 = date.matches(DATE_PATTERN_V1);
//        System.out.println(res_opt1 || res_opt2);
//        return new String[] { date, String.valueOf(res_opt1 || res_opt2)};
//    }

    private static void task_2() {
//        MilksProduct milk = new MilksProduct("sour cream", 58.0, (short) 2, 5);
//        System.out.println(milk);
//        MeatsProduct meat = new MeatsProduct("chicken", 120.45, (short) 2, 8);
//        System.out.println(meat);
//        DrinksProduct coca = new DrinksProduct("coca-cola", 46.99, (short) 3, 6);
//        System.out.println(coca);
    }

    public static void task_1() {
//        boolean isEnough = false;
//        List<Deal> list_deal = new ArrayList<>();
//        while (!isEnough) {
//            System.out.print("Need to add a new deal? (y/n): ");
//            char request = scan.next().charAt(0);
//            if (request == 'n') {
//                isEnough = true;
//                break;
//            }
//            else {
//                scan.nextLine();
//                System.out.print("product name: ");
//                String productName = scan.nextLine();
//                System.out.print("product price: ");
//                double productPrice = scan.nextDouble();
//                System.out.print("product count: ");
//                short productCount = scan.nextShort();
//                if (productCount <= 0){
//                    System.out.println("The number cannot be equal to or less than 0.");
//                    return;
//                }
//                scan.nextLine();
//                System.out.print("customer name: ");
//                String customer = scan.nextLine();
//                System.out.print("comment for deal: ");
//                String commentDeal = scan.nextLine();
//                list_deal.add(new Deal(productName, productPrice, productCount, customer, commentDeal));
//            }
//        }
//
//        for (int i = 0; i < list_deal.size(); i++) {
//            System.out.print(list_deal.get(i).toString());
//        }
    }
}
