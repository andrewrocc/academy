package by.academy.homework3;

import by.academy.homework3.model.*;
import by.academy.homework3.services.*;
import by.academy.homework3.services.Serializer.FileIOServise;
import by.academy.homework3.services.Serializer.InfoFileParser;

import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    //region static fields
    public static final Scanner scan = new Scanner(System.in);

    private static final String fileName = "data.bin";

    private static final Path currentRelativePath = Paths.get("");

    private static final String currentDirectory = currentRelativePath.toAbsolutePath().toString().concat("\\" + fileName);

    private static final String MILKS_PRODUCT = "Milks";

    private static final String DRINKS_PRODUCT = "Drinks";

    private static final String MEATS_PRODUCT = "Meats";

    private static FileIOServise<ListProduct> ioServise = new FileIOServise(currentDirectory);

    private static ListProduct buyerBasket = new ListProduct();

    static List<String> milksProduct;

    static List<String> drinksProduct;

    static List<String> meatsProduct;

    static List<String> allProducts;

    static ListProduct binInfo;

    static {
        binInfo = (ListProduct) ioServise.loadData();
        milksProduct = new InfoFileParser().getArrayProduct(binInfo.toString(), MILKS_PRODUCT);
        drinksProduct = new InfoFileParser().getArrayProduct(binInfo.toString(), DRINKS_PRODUCT);
        meatsProduct = new InfoFileParser().getArrayProduct(binInfo.toString(), MEATS_PRODUCT);
        allProducts = new ArrayList<>();
        allProducts.addAll(milksProduct);         // milksProduct + drinksProduct + meatsProduct;
        allProducts.addAll(meatsProduct);
        allProducts.addAll(drinksProduct);
    }
    //endregion

    public static void main(String[] args) {

        User seller;
        User buyer = null;
        do {
            seller = setUserInfo("seller");
            if (seller == null) {
                System.out.println("The seller information needs to be corrected!!!\n");
                continue;
            }

            buyer = setUserInfo("buyer");
            if (buyer == null) {
                System.out.println("The buyer information needs to be corrected");
            }
        } while ((seller == null) && (buyer == null));


        ListProduct listProduct = new ListProduct();
        Deal deal = new Deal(seller, buyer, listProduct);
        do {
            int pointMenu = mainMenu();

            switch (pointMenu) {
                case 1: shopCatalog(); break;
                case 2: shopBasket(""); break;
                case 3: exitMoment(deal); scan.close(); return;
                default:
                    System.out.println("You did not select any point.");
            }

        } while(true);

//        User a = User.isValidDataFormat("an", 123.2, LocalDate.parse("08-01-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "wergf@gmai.com", "+375334560099");
//        System.out.println(a);
    }

    public static int mainMenu() {
        int response;
        do {
            System.out.println("1. Shop catalog\n2. Basket\n3. Exit");
            response = scan.nextInt();
        } while (response < 0 && response > 4);
        return response;
    }

    public static void shopCatalog() {
        int response;
        do {
            System.out.println("1. Milks\n2. Meats\n3. Drinks\n4. All products\n5.Back to main menu");
            response = scan.nextInt();
            switch (response) {
                case 1: productCatalog(MILKS_PRODUCT); break;
                case 2: productCatalog(MEATS_PRODUCT); break;
                case 3: productCatalog(DRINKS_PRODUCT); return;
                case 4: productCatalog(""); return;
                case 5: return;
                default:
                    System.out.println("You did not select any point.");
            }

        } while(true);
    }

    public static int productCatalog(String productType) {
        int response;
        List<String> selectedProduct = productType.equals(MILKS_PRODUCT) ? milksProduct :
        productType.equals(MEATS_PRODUCT) ? meatsProduct :
        productType.equals(DRINKS_PRODUCT) ? drinksProduct : allProducts;
        do {
            for (int i = 0; i < selectedProduct.size(); i++) {
                System.out.println(i + 1 + " - " + selectedProduct.get(i));         //.replace("}, ", "}, \n");
            }
            System.out.println("\n------------------------\n1. Buy position\n2. Go to basket\n3. Back to main menu");
            response = scan.nextInt();
            if (response == 1) {
                System.out.print("Enter the number position: ");
                int position = scan.nextInt();
                System.out.print("Enter the quantity: ");
                short quantity = scan.nextShort();
                var e = binInfo.get(position);
                buyerBasket.add(e);
            }
        } while(response > 0 && response < 4);
        return response;
    }

    private static void shopBasket(String s) {  }

    public static void exitMoment(Deal deal) {
        if (deal.getListProduct().getStorage()[0] == null) {
            System.out.println("Your check is empty.");
        } else {
            System.out.println(deal);
        }
    }

    public static User setUserInfo(String userType) {
        String userName, userEmail, userPhone;
        double userMoney;
        LocalDate dateOfBirth;
        System.out.print("Enter the " + userType + " name: ");
        userName = scan.nextLine();
        System.out.print("Enter the " + userType + " email: ");
        userEmail = scan.nextLine();
        System.out.print("Enter the " + userType + " phone(+357...): ");
        userPhone = scan.nextLine();
        System.out.print("Enter the " + userType + " money: ");
        userMoney = scan.nextDouble();
        System.out.print("Enter the " + userType + " date of birth(d-m-y): ");
        String dateString = scan.nextLine();
        dateString = scan.nextLine();
//        dateOfBirth = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return User.isValidDataFormat(userName, userMoney, dateString, userEmail, userPhone);
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
//        FileIOServise ioServise = new FileIOServise(currentDirectory);
//
//        // serialise data (save data)
//        ListProduct listToFile = new ListProduct();
//        listToFile.add(new Milks("Milk",15.5, (short) 1, 0.3, true, 5.1));
//        listToFile.add(new Meats("Chicken", 26.99, (short) 1, 0.3, true, 3.23));
//        listToFile.add(new Milks("Cheese", 45.0, (short) 1, 0.3, true, 0.561));
//        listToFile.add(new Milks("Ice-cream", 9.99, (short) 1, 0.3, true, 6.98));
//        listToFile.add(new Meats("Pizza",  31.95, (short) 1, 0.3, true, 3.56));
//        listToFile.add(new Drinks("Coke", 7.0, (short) 1, 0.3, true, 6.1));
//        listToFile.add(new Drinks("Coffee", 7.0, (short) 1, 0.3, true, 2.0));
//        listToFile.add(new Drinks("Tea", 7.0, (short) 1, 0.3, true, 7.8));
//        listToFile.add(new Drinks("Water", 7.0, (short) 1, 0.3, true, 3.1));
//        listToFile.add(new Milks("Sour-cream", 4.0, (short) 1, 0.3, true, 6.1));
//        ioServise.saveData(listToFile);
//
//        // deserialize data(load data)
//        ListProduct list = (ListProduct) ioServise.loadData();
//        System.out.println(list.toString());
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

}
