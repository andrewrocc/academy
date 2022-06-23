package by.academy.homework3;

class Product {

    //region fields
    private String productName;
    private double cost;
    private short productCount;
    //endregion
    public Product(String productName, double cost, short productCount) {
        this.productName = productName;
        this.cost = cost;
        this.productCount = productCount;
    }
    @Override
    public String toString() {
        return String.format("Product { name = '%s', cost = '%6.2f', count = '%d' }",
                            productName, cost, productCount);
    }

    //region properties of fields
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public short getProductCount() {
        return productCount;
    }

    public void setProductCount(short productCount) {
        this.productCount = productCount;
    }
    //endregion
}
