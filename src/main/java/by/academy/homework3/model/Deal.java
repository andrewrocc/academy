package by.academy.homework3.model;

import by.academy.homework3.services.ListProduct;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Deal {

    //region fields
    private User seller, buyer;

    private ListProduct listProduct;

    private LocalDateTime dealTime, deadLine;

    double totalPrice = 0.0;
    //endregion

    //region prop
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public ListProduct getListProduct() {
        return listProduct;
    }

    public void setListProduct(ListProduct listProduct) {
        this.listProduct = listProduct;
    }

    public LocalDateTime getDealTime() {
        return dealTime;
    }

    public void setDealTime(LocalDateTime dealTime) {
        this.dealTime = dealTime;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }
    //endregion

    public Deal(User seller, User buyer, ListProduct listProduct) {
        this.seller = seller;
        this.buyer = buyer;
        this.listProduct = listProduct;
    }

    //region Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deal deal = (Deal) o;

        if (!Objects.equals(seller, deal.seller)) return false;
        if (!Objects.equals(buyer, deal.buyer)) return false;
        if (!Objects.equals(listProduct, deal.listProduct)) return false;
        if (!Objects.equals(dealTime, deal.dealTime)) return false;
        return Objects.equals(deadLine, deal.deadLine);
    }

    @Override
    public int hashCode() {
        int result = seller != null ? seller.hashCode() : 0;
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        result = 31 * result + (listProduct != null ? listProduct.hashCode() : 0);
        result = 31 * result + (dealTime != null ? dealTime.hashCode() : 0);
        result = 31 * result + (deadLine != null ? deadLine.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Deal { seller = '%s', buyer = '%s', list product = '%s', date-time deal = '%tc' }",
                seller, buyer, Arrays.deepToString(listProduct.getStorage()), dealTime);
    }
    //endregion

    public double totalPrice() {
        for (var e : listProduct.getStorage()) {
            if (e == null) {
                break;
            }
            totalPrice += (e.getProductPrice() * e.getProductQuantity() * (1 + e.getProductTax()));      // if tax = 3% -> price * 1.03
        }
        return totalPrice;
    }

    private boolean dealTransaction() {
        if (buyer.getUserMoney() > totalPrice) {
            buyer.setUserMoney(buyer.getUserMoney() - totalPrice);
            seller.setUserMoney(seller.getUserMoney() + totalPrice);
            return true;
        }
        return false;
    }

    public void deal() {
        if (listProduct.isEmpty()) {
            System.out.println("Your check list is empty.");
            return;
        }
        dealTime = LocalDateTime.now();
        deadLine = dealTime.plusDays(10);
        totalPrice = totalPrice();
        if (dealTransaction()) {
            printCheckList();
        } else {
            System.out.printf("Buyer %s, has no enough money for the deal.\n", buyer.getUserName());
        }
    }

    private void printCheckList() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.printf(
                """
                        -------------------------------------------------
                        |                  Check list                    |
                        -------------------------------------------------
                               Buyer - %s,                              \s
                               Seller - %s,                             \s
                               Deal date - %s                           \s
                        -------------------------------------------------
                        """
                , buyer.getUserName(), seller.getUserName(), dealTime.format(formatter));

        for (int i = 0; i < listProduct.size(); i++) {
            int tabSymbols = (listProduct.get(i).productName.length() >= 7) ? 2 : 4;
            System.out.printf(
                    (i + 1) + " " + "%s" + "\t".repeat(tabSymbols) + "%d" + "\t".repeat(2) + "%.2f" + "\t".repeat(3) + "%.2f\n",
                    listProduct.get(i).productName, listProduct.get(i).productQuantity, listProduct.get(i).productTax, listProduct.get(i).productPrice);
        }

        System.out.printf(
                """
                        -------------------------------------------------
                        |                    Total price : %.2f        |
                        -------------------------------------------------
                        """
                , totalPrice);
    }
}
