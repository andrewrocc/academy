package by.academy.homework8.service;

import by.academy.homework8.model.*;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;

public class FileIOService {

    private final String PATH;

    public FileIOService(String PATH) {
        this.PATH = PATH;
    }

    public void saveData() throws IOException {
        PassengerPlane airbusA320 = new PassengerPlane("Airbus", "A320", "20150510_A4532", 4010.0, 2400, 8510.50, 180);
        PassengerPlane boeing777 = new PassengerPlane("Boeing", "777", "12122010-MB2314", 9100.0,  6100.0, 15_660.0, 400);
        WideBodyPlane airbusA350 = new WideBodyPlane("Airbus", "A350-1000", "10022005T35656G", 16_100.0, 5800.0, 480);
        WideBodyPlane airbusA340 = new WideBodyPlane("Airbus", "A340-600", "10022008T354611Q", 12_050.0, 3700.0, 380);
        CargoPlane airbus380 = new CargoPlane("Airbus", "380", "23102012-23K04RK", 15_400.0, 4670.0, 560_000);
        CargoPlane boeing747 = new CargoPlane("Boeing", "747 Dreamlifter", "23102012-QQ147RO", 7800.0, 6150.10, 113_400 );
        ArrayList<Plane> planes = new ArrayList<>(List.of(airbusA320, boeing777, airbusA350, airbusA340, airbus380, boeing747));

        File file = new File(PATH);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(PATH)))) {
            xmlEncoder.writeObject(planes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Plane> loadData() throws IOException {
        if (!new File(PATH).exists()) {
            throw new IOException("Error! Have not data file.");
        }

        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(PATH)))) {
              return (ArrayList<Plane>) xmlDecoder.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
