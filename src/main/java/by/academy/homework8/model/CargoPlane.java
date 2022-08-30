package by.academy.homework8.model;

public class CargoPlane extends Plane {

    private double weightCapacity;

    public CargoPlane(String planeBrand, String planeModel, String planeSerialNumber,
                      double flightRange, double fuelConsumption, double weightCapacity) {
        super(planeBrand, planeModel, planeSerialNumber, flightRange, fuelConsumption);
        this.weightCapacity = weightCapacity;
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    @Override
    public int getSeatsCapacity() {
        return 0;
    }

    @Override
    public void setSeatsCapacity(int seatsCapacity) { }
}
