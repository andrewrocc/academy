package by.academy.homework3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class Deal {
    //region fields of class
    private String productName;
    private double productPrice;
    private short productCount;
    private String customer;
    private Date dateTimeDeal;
    private String commentDeal;
    private double totalPrice;

    private Date deadline;
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
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTimeDeal);
        cal.add(Calendar.DATE, 10);
        deadline = cal.getTime();
    }

    @Override
    public String toString() {
        return String.format("Deal { product name = '%s', " +
                            "product count = '%d', " +
                            "customer = '%s', " +
                            "date time deal = '%tc', " +
                            "comment deal = '%s', " +
                            "total price = '%.2f' " +
                            "deadline = '%tc' " + "}",
                            productName, productCount, customer, dateTimeDeal, commentDeal, totalPrice, deadline);
    }
}
