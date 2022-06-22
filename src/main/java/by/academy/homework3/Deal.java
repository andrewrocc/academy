package by.academy.homework3;

import java.util.Date;

class Deal {
    //region fields of class
    private String productName;
    private double productPrice;
    private short productCount;
    private String customer;
    private Date dateTimeDeal;
    private String commentDeal;

    private double totalPrice;
    //endregion

    public Deal(String productName, double productPrice, short productCount, String customer,
                String commentDeal) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.customer = customer;
        this.dateTimeDeal = new Date();
        this.commentDeal = commentDeal;
        totalPrice = productPrice * productCount;
    }

    @Override
    public String toString() {
        return String.format("Deal { product name = '%s', " +
                            "product count = '%d', " +
                            "customer = '%s', " +
                            "date time deal = '%tc', " +
                            "comment deal = '%s', " +
                            "total price = '%4.2f' }",
                            productName, productCount, customer, dateTimeDeal, commentDeal, totalPrice);
    }
}
