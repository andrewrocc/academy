package by.academy.homework3;

import by.academy.homework3.model.Deal;
import by.academy.homework3.model.User;
import by.academy.homework3.services.ListProduct;
import by.academy.homework3.services.Serializer.FileIOServise;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    //region static fields
    public static final Scanner scan = new Scanner(System.in);

    private static final String fileName = "data.bin";

    private static final Path currentRelativePath = Paths.get("");

    private static final String currentDirectory = currentRelativePath.toAbsolutePath().toString().concat("\\" + fileName);

    private static final String MILKS_PRODUCT = "Milks";

    private static final String DRINKS_PRODUCT = "Drinks";

    private static final String MEATS_PRODUCT = "Meats";

    private static final FileIOServise<ListProduct> ioServise = new FileIOServise(currentDirectory);

    private static ListProduct buyerBasket = new ListProduct();

    static ListProduct binInfo;

    static ListProduct milksProduct;

    static ListProduct meatsProduct;

    static ListProduct drinksProduct;

    static {
        binInfo = (ListProduct) ioServise.loadData();
        milksProduct = new FileIOServise().getArrayProduct(binInfo, MILKS_PRODUCT);
        meatsProduct = new FileIOServise().getArrayProduct(binInfo, MEATS_PRODUCT);
        drinksProduct = new FileIOServise().getArrayProduct(binInfo, DRINKS_PRODUCT);
    }

    public static Deal deal;
    //endregion

    public static void main(String[] args) {

        User seller = null;
        User buyer = null;
        do {
            if (seller == null) {
                seller = setUserInfo("seller");
                if (seller == null) {
                    System.out.println("The seller information needs to be corrected!!!\n");
                    continue;
                }
            }

            buyer = setUserInfo("buyer");
            if (buyer == null) {
                System.out.println("The buyer information needs to be corrected");
            }
        } while ((seller == null) || (buyer == null));

        System.out.println("\n" + buyer);
        System.out.println(seller);

        deal = new Deal(seller, buyer, buyerBasket);
        do {
            int pointMenu = mainMenu();

            switch (pointMenu) {
                case 1 -> shopCatalog();
                case 2 -> shopBasket();
                case 3 -> {
                    exitMoment(deal);
                    scan.close();
                    return;
                }
                default -> System.out.println("You did not select any point.");
            }
        } while (true);

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
        System.out.println("1. Milks\n2. Meats\n3. Drinks\n4. All products\n5. Back to main menu");
        response = scan.nextInt();
        switch (response) {
            case 1 -> productCatalog(MILKS_PRODUCT);
            case 2 -> productCatalog(MEATS_PRODUCT);
            case 3 -> productCatalog(DRINKS_PRODUCT);
            case 4 -> productCatalog("");
            case 5 -> mainMenu();
            default -> System.out.println("You did not select any point.");
        }
    }

    public static void productCatalog(String productType) {         // int
        int response;
        var selectedProduct = productType.equals(MILKS_PRODUCT) ? milksProduct :
                                        productType.equals(MEATS_PRODUCT) ? meatsProduct :
                                        productType.equals(DRINKS_PRODUCT) ? drinksProduct : binInfo;
        selectedProduct.refreshSize();                  // need this method cuz binInfo is deserialized data and has no actual size
            for (int i = 0; i < selectedProduct.size(); i++) {
                System.out.println(i + 1 + " - " + selectedProduct.get(i));
            }
            System.out.println("\n------------------------\n1. Buy position\n2. Go to basket\n3. Back to main menu");
            response = scan.nextInt();
        switch (response) {
            case 1 -> {
                System.out.print("Enter the number position: ");
                int position = scan.nextInt();
                if (position > selectedProduct.size()) {
                    System.out.println("Incorrect value.");
                } else {
                    System.out.print("Enter the quantity position: ");
                    short quantity = scan.nextShort();
                    var e = selectedProduct.get(position - 1);
                    e.setProductQuantity(quantity);
                    buyerBasket.add(e);
                }
            }
            case 2 -> shopBasket();
            case 3 -> mainMenu();
            default -> System.out.println("Incorrect value.");
        }
    }

    private static void shopBasket() {
        int response;
        if (buyerBasket.isEmpty()) {
            System.out.println("Your basket is empty.");
            return;
        }
        for (int i = 0; i < buyerBasket.size(); i++) {
            System.out.println(i + 1 + " - " + buyerBasket.get(i));
        }
        do {
            System.out.println("\n------------------------\n1. Buy all\n2. Remove position\n3. Back to main menu");
            response = scan.nextInt();
            if (response == 1) {
                deal.deal();
                System.exit(0);
            } else if (response == 2) {
                System.out.print("Enter the number of the item to be deleted: ");
                int deletePosition = scan.nextInt();
                buyerBasket.removeAt(deletePosition - 1);
            } else {
                mainMenu();
            }
        } while (response < 0 && response > 4);
    }

    public static void exitMoment(Deal deal) {
        System.out.println(
                (deal.getListProduct().isEmpty())
                        ? "Your basket is empty."
                        : deal
        );
    }

    // this is so long latency to enter all variables cuz, made full auto,
    // (uncomment the lines if you need to enter manually & comment all condition)
    public static User setUserInfo(String userType) {
//        String userName, userEmail, userPhone;
//        double userMoney;
//        LocalDate dateOfBirth;

        // comment this all condition
        String userName, userEmail, userPhone;
        double userMoney;
        String dateOfBirth;
        if (userType.equals("buyer")) {
            userName = "lewis";
            userEmail = "ajhgfawf@mail.com";
            userPhone = "+375663330022";
            userMoney = 2345345.0;
            dateOfBirth = "12-12-2000";
        } else {
            userName = "tom";
            userEmail = "ajhgfawf@mail.com";
            userPhone = "+375663330022";
            userMoney = 124124.0;
            dateOfBirth = "12-12-2000";
        }

        System.out.print("Enter the " + userType + " name: ");
//        userName = scan.nextLine();
        System.out.print("Enter the " + userType + " email: ");
//        userEmail = scan.nextLine();
        System.out.print("Enter the " + userType + " phone(+357...): ");
//        userPhone = scan.nextLine();
        System.out.print("Enter the " + userType + " money: ");
//        userMoney = scan.nextDouble();
        System.out.print("Enter the " + userType + " date of birth(d-m-y): ");
//        String dateString = scan.nextLine();
//        dateString = scan.nextLine();
//        return User.isValidDataFormat(userName, userMoney, dateString, userEmail, userPhone);
        return User.isValidDataFormat(userName, userMoney, dateOfBirth, userEmail, userPhone);
    }
}
