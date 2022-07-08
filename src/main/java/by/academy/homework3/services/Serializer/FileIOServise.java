package by.academy.homework3.services.Serializer;

import by.academy.homework3.model.Drinks;
import by.academy.homework3.model.Meats;
import by.academy.homework3.model.Milks;
import by.academy.homework3.services.ListProduct;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileIOServise {

    private final String PATH;

    public FileIOServise(String PATH) {
        this.PATH = PATH;
    }

    public Object loadData() {
        boolean isExists = new File(PATH).exists();
        if (!isExists) {
            new File(PATH);
            return null;
        }
        try (FileReader reader = new FileReader(PATH)) {
            return new Gson().fromJson(reader, Object.class);
        } catch (Exception ex) {
            System.out.println("Parsing error: " + ex.toString());
            return null;
        }
    }

    public void saveData(Object list) {
        try (FileWriter writer = new FileWriter(PATH)) {
            new Gson().toJson(list, writer);
        } catch (Exception ex) {
            System.out.println("Parsing error: " + ex.toString());
        }
    }
}
