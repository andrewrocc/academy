package by.academy.homework3.model;

import java.util.Objects;

public class Drinks extends Product {

    //region fields
    private boolean isFresh;
    private double weight = 0.0d;
    //endregion

    //region properties
    public boolean getFresh() {
        return isFresh;
    }

    public void setFresh(boolean fresh) {
        this.isFresh = fresh;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    //endregion

    public Drinks(String productName, double productPrice, short productQuantity, double productTax, boolean isFresh, double weight) {
        super(productName, productPrice, productQuantity, productTax);
        this.isFresh = isFresh;
        this.weight = weight;
    }

    @Override
    public double discount() {
        return (weight > 4.0 && isFresh) ?
                calculatePrice() * 0.93 :
                calculatePrice();
    }

    //region javaBean(override)
    @Override
    public String toString() {
        return String.format("DrinksProduct { name = '%s', cost = '%6.2f', count = '%d', fresh = '%s', weight = '%.2f'}",
                getProductName(), getProductPrice(), getProductQuantity(), isFresh, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drinks that)) return false;
        if (!super.equals(o)) return false;
        return isFresh == that.isFresh && Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isFresh, weight);
    }
    //endregion
}
