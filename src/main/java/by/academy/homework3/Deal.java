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
        return "Deal {" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCount=" + productCount +
                ", customer='" + customer + '\'' +
                ", dateTimeDeal=" + dateTimeDeal +
                ", commentDeal='" + commentDeal + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

    //region properties for fields
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

    public short getProductCount() {
        return productCount;
    }

    public void setProductCount(short productCount) {
        this.productCount = productCount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        customer = customer;
    }

    public Date getDateTimeDeal() {
        return dateTimeDeal;
    }

    public void setDateTimeDeal(Date dateTimeDeal) {
        this.dateTimeDeal = dateTimeDeal;
    }

    public String getCommentDeal() {
        return commentDeal;
    }

    public void setCommentDeal(String commentDeal) {
        this.commentDeal = commentDeal;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //endregion
}
