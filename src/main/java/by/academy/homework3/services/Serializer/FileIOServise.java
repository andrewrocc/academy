package by.academy.homework3.services.Serializer;

import by.academy.homework3.services.ListProduct;

import java.io.*;

public class FileIOServise<T> {

    private String PATH;

    public FileIOServise(String PATH) {
        this.PATH = PATH;
    }

    public FileIOServise() { }

    public <T> Object loadData() {
        try {
            FileInputStream fileInput = new FileInputStream(PATH);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            return (T)objectInput.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public <T> void saveData(T list) {
        try  {
            FileOutputStream fileOutput = new FileOutputStream(PATH);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
            outputStream.writeObject(list);

            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ListProduct getArrayProduct(ListProduct listProduct, String productType) {
        ListProduct l_product = new ListProduct();
        for (var e : listProduct.getStorage()) {
            if (e.toString().contains(productType)) {
                l_product.add(e);
            }
        }
        return l_product;
    }
}
