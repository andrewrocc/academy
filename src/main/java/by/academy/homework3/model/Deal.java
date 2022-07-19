package by.academy.homework3.model;

import java.time.LocalDateTime;
import java.util.*;

public class Deal {

    //region fields
    private User seller;

    private User buyer;

    private Product[] listProduct;

    private LocalDateTime dealTime;

    private LocalDateTime deadLine;
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

    public Product[] getListProduct() {
        return listProduct;
    }

    public void setListProduct(Product[] listProduct) {
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

    public Deal(User seller, User buyer, Product[] listProduct) {
        this.seller = seller;
        this.buyer = buyer;
        this.listProduct = listProduct;
    }

    //region Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deal deal)) return false;
        return Objects.equals(seller, deal.seller) && Objects.equals(buyer, deal.buyer) &&
                                Arrays.equals(listProduct, deal.listProduct) &&
                                Objects.equals(dealTime, deal.dealTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(seller, buyer, dealTime);
        result = 31 * result + Arrays.hashCode(listProduct);
        return result;
    }

    @Override
    public String toString() {
        return String.format("Deal { seller = '%s', buyer = '%s', list product = '%s', date-time deal = '%tc' }",
                            seller, buyer, Arrays.deepToString(listProduct), dealTime);
    }
    //endregion

    public double totalPrice() {
        // some math and beautiful code, that not final version
        double total_price = 0.0;
        for (var e : listProduct) {
            total_price += (e.getProductPrice() * e.getProductQuantity() * (1 + e.getProductTax()));      // if tax = 3% -> price * 1.03
        }
        return total_price;
    }

    public void deal() {
        // some math and beautiful code
        dealTime = LocalDateTime.now();
        deadLine = deadLine.plusDays(10);
    }
}
