package by.academy.homework3;

public class DrinksProduct extends Product {

    private int discount;
    private double costDiscount = 0.0d;

    //region properties
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getCostDiscount() {
        return costDiscount;
    }

    public void setCostDiscount(double costDiscount) {
        this.costDiscount = costDiscount;
    }
    //endregion

    public DrinksProduct(String productName, double cost, short productCount, int discount) {
        super(productName, cost, productCount);
        this.discount = discount;
        costDiscount = (cost - ((cost * discount) / 100)) * productCount;
    }

    @Override
    public String toString() {
        return String.format("DrinksProduct { name = '%s', cost = '%6.2f', count = '%d', discount = '%d%%', costDiscount = '%6.2f'}",
                getProductName(), getCost(), getProductCount(), discount, costDiscount);
    }
}