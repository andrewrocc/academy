package by.academy.homework3.model;

import by.academy.homework3.services.ListProduct;

import java.time.LocalDateTime;
import java.util.*;

public class Deal {

    //region fields
    private User seller, buyer;

    private ListProduct listProduct;

    private LocalDateTime dealTime, deadLine;
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
        // some math and beautiful code, that not final version
        double total_price = 0.0;
        for (var e : listProduct.getStorage()) {
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
