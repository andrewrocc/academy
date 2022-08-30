package by.academy.homework8.model;

public class WideBodyPlane extends Plane {

    private int seatsCapacity;

    public WideBodyPlane(String planeBrand, String planeModel, String planeSerialNumber,
                         double flightRange, double fuelConsumption, int seatsCapacity) {
        super(planeBrand, planeModel, planeSerialNumber, flightRange, fuelConsumption);
        this.seatsCapacity = seatsCapacity;
    }

    @Override
    double getWeightCapacity() {
        return 0;
    }

    @Override
    void setWeightCapacity(double weightCapacity) { }

    @Override
    public int getSeatsCapacity() {
        return seatsCapacity;
    }

    @Override
    public void setSeatsCapacity(int seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }
}
