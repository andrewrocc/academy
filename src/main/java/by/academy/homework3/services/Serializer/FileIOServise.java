package by.academy.homework3.services.Serializer;

import java.io.*;

public class FileIOServise<T> {

    private final String PATH;

    public FileIOServise(String PATH) {
        this.PATH = PATH;
    }

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
}
