package by.academy.homework3.model;

import java.util.Objects;

public class Product {

    //region fields
    private String productName;

    private double productPrice;

    private short productQuantity;

    private double productTax;
    //endregion

    //region prop
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public short getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(short productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getProductTax() {
        return productTax;
    }

    public void setProductTax(double productTax) {
        this.productTax = productTax;
    }
    //endregion

    public Product(String productName, double productPrice, short productQuantity, double productTax) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productTax = productTax;
    }

    //region Overrides methods
    @Override
    public String toString() {
        return String.format("Product { name = '%s', price = '%.2f', quantity = '%d', tax = '%f' }",
                            productName, productPrice, productQuantity, productTax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Double.compare(product.productPrice, productPrice) == 0 &&
                            productQuantity == product.productQuantity &&
                            Double.compare(product.productTax, productTax) == 0 &&
                            Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice, productQuantity, productTax);
    }
    //endregion

    private double discount() {
        // some math and beautiful code, that not final version
        return ((productPrice * productQuantity) + productTax) * 0.95;
    }

    private double calculatePrice() {
        // some math and beautiful code, idk wat this method is for?
        return 1.0;
    }
}
