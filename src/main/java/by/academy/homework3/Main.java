package by.academy.homework3;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        task_1();

        scan.close();
    }

    public static void task_1() {
        boolean isEnough = false;
        List<Deal> list_deal = new ArrayList<>();
        while (!isEnough) {
            System.out.print("Need to add a new deal? (y/n): ");
            char request = scan.next().charAt(0);
            if (request == 'n') {
                isEnough = true;
                break;
            }
            else {
                scan.nextLine();
                System.out.print("product name: ");
                String productName = scan.nextLine();
                System.out.print("product price: ");
                double productPrice = scan.nextDouble();
                System.out.print("product count: ");
                short productCount = scan.nextShort();
                scan.nextLine();
                System.out.print("customer name: ");
                String customer = scan.nextLine();
                System.out.print("comment for deal: ");
                String commentDeal = scan.nextLine();
                list_deal.add(new Deal(productName, productPrice, productCount, customer, commentDeal));
            }
        }
    }
}
