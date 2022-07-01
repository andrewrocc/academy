package by.academy.homework3;

import by.academy.homework3.model.Product;

import java.util.ArrayList;
import java.util.Collection;

//class ListProducts {
//
//    private ArrayList<Product> list_products;
//
//    //region prop
//    public ArrayList<Product> getList_products() {
//        return list_products;
//    }
//
//    public void setList_products(ArrayList<Product> list_products) {
//        this.list_products = list_products;
//    }
//    //endregion
//
//    @Override
//    public String toString() {
//        StringBuilder result = new StringBuilder("List of deals: ");
//        if (list_products.isEmpty()) {
//            return "List of deals is empty.";
//        }
//        for (int i = 0; i < list_products.size(); i++) {
//            result.append("Deal ").append(i).append(list_products.get(i).toString());
//        }
//        return result.toString();
//    }
//
//    //region list operations
//    public void add_deal(Product product) {
//        if (isNullOrEmpty(list_products)) {
//            list_products = new ArrayList<>();
//        }
//        list_products.add(product);
//    }
//
//    public void remove_deal(Product product) {
//        if (isNullOrEmpty(list_products)) {
//            throw new IndexOutOfBoundsException("List of deals are empty.");
//        }
//        list_products.remove(product);
//    }
//
//    public int size_deal() {
//        return list_products.size();
//    }
//
//    public Product get_i(int index) {
//        return list_products.get(index);
//    }
//    //endregion
//
//    private boolean isNullOrEmpty(final Collection<?> collection) {
//        return collection == null || collection.isEmpty();
//    }
//}
