package by.academy.homework8.serice;

import by.academy.homework8.model.Plane;

import java.util.Comparator;

public class SortByRange implements Comparator<Plane> {
    @Override
    public int compare(Plane planeOne, Plane planeTwo) {
        return Double.compare(planeOne.getFlightRange(), planeTwo.getFlightRange());
    }
}
