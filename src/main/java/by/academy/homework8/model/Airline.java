package by.academy.homework8.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Airline {

    private String airlineBrand;

    private final List<Plane> planeList;

    public Airline(String airlineBrand, List<Plane> planeList) {
        this.airlineBrand = airlineBrand;
        this.planeList = planeList;
    }

    public String getAirlineBrand() {
        return airlineBrand;
    }

    public void setAirlineBrand(String airlineBrand) {
        this.airlineBrand = airlineBrand;
    }

    public void sortPlanesByRange() {
        planeList.sort(Comparator.comparingDouble(Plane::getFlightRange));
    }

    public void getTotalCargoPassengerCapacity() {
        int totalPassengerCapacity = 0;
        double totalCargoCapacity = 0;
        for (Plane plane : planeList) {
            totalPassengerCapacity += plane.getSeatsCapacity();
            totalCargoCapacity += plane.getWeightCapacity();
        }

        System.out.println("Total passenger capacity = " + totalPassengerCapacity);
        System.out.println("Total cargo capacity = " + totalCargoCapacity);
    }

    public ArrayList<Plane> getPlaneByFuelConsumption(double fuelConsumptionMin, double fuelConsumptionMax) {
        ArrayList<Plane> filteredAirline = new ArrayList<>();
        for (Plane plane : planeList) {
            double currentConsumption = plane.getFuelConsumption();
            if (currentConsumption >= fuelConsumptionMin && currentConsumption <= fuelConsumptionMax) {
                filteredAirline.add(plane);
            }
        }
        return filteredAirline;
    }

    @Override
    public String toString() {
        return "Airline { " +
                "airlineBrand= " + airlineBrand + ",\n" +
                "planeList= \n" + planeList.toString().replace("},", "},\n" ) +
                " }s";
    }
}