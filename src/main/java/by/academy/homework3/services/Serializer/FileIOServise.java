package by.academy.homework3.services.Serializer;

import by.academy.homework3.model.Drinks;
import by.academy.homework3.model.Meats;
import by.academy.homework3.model.Milks;
import by.academy.homework3.services.ListProduct;

import java.io.*;

public class FileIOServise<T> {

    private String PATH;

    public FileIOServise(String PATH) {
        this.PATH = PATH;
    }

    public FileIOServise() { }

    public <T> Object loadData() {
        boolean isExists = new File(PATH).exists();
        if (!isExists) {
            new File(PATH);
            setBinaryCatalog();
        }

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

    private void setBinaryCatalog() {
        FileIOServise ioServise = new FileIOServise(PATH);

        // serialise data (save data)
        ListProduct listToFile = new ListProduct();
        listToFile.add(new Milks("Milk",15.5, (short) 1, 0.03, true, 5.1));
        listToFile.add(new Meats("Chicken", 26.99, (short) 1, 0.03, true, 3.23));
        listToFile.add(new Milks("Cheese", 45.0, (short) 1, 0.03, true, 0.561));
        listToFile.add(new Milks("Ice-cream", 9.99, (short) 1, 0.03, true, 6.98));
        listToFile.add(new Meats("Pizza",  31.95, (short) 1, 0.03, true, 3.56));
        listToFile.add(new Drinks("Coke", 7.0, (short) 1, 0.03, true, 6.1));
        listToFile.add(new Drinks("Coffee", 7.0, (short) 1, 0.03, true, 2.0));
        listToFile.add(new Drinks("Tea", 7.0, (short) 1, 0.03, true, 7.8));
        listToFile.add(new Drinks("Water", 7.0, (short) 1, 0.03, true, 3.1));
        listToFile.add(new Milks("Sour-cream", 4.0, (short) 1, 0.03, true, 6.1));
        ioServise.saveData(listToFile);
    }
}
