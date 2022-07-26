package by.academy.homework3.services.Serializer;

import java.util.ArrayList;
import java.util.List;

public class InfoFileParser {

    public List<String> getArrayProduct(String binInfo, String productType) {
        List<String> productList = new ArrayList<>();
        String[] productTypeArray = binInfo.substring(23, binInfo.length() - 2).split("\n");
        for (var string: productTypeArray) {
            if (string.contains(productType)) {
                productList.add(string);
            }
        }

        return productList;
    }
}
