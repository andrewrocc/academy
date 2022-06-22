package by.academy.homework3;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        task_1();
//        task_2();
        task_3();

        scan.close();
    }

    private static void task_3() {
        System.out.print("Enter the date format(dd/mm/yyyy) or (dd-mm-yyyy): ");
        String date = scan.nextLine();
        boolean res_opt1 = date.matches("(0[1-9]|1\\d|2\\d|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/(\\d{4})");
        boolean res_opt2 = date.matches("(0[1-9]|1\\d|2\\d|3[0-1]|[1-9])-(0[1-9]|1[0-2]|[1-9])-(\\d{4})");
        System.out.println(res_opt1 || res_opt2);
    }

    private static void task_2() {
        try {
            throw new ExecutionControl.NotImplementedException("not implemented method");
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
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
                if (productCount <= 0){
                    System.out.println("The number cannot be equal to or less than 0.");
                    return;
                }
                scan.nextLine();
                System.out.print("customer name: ");
                String customer = scan.nextLine();
                System.out.print("comment for deal: ");
                String commentDeal = scan.nextLine();
                list_deal.add(new Deal(productName, productPrice, productCount, customer, commentDeal));
            }
        }

        for (int i = 0; i < list_deal.size(); i++) {
            System.out.print(list_deal.get(i).toString());
        }
    }
}
