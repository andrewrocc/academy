package by.academy.homework8.model;

public class PassengerPlane extends Plane {

    private double weightCapacity;

    private int seatsCapacity;

    public PassengerPlane(String planeBrand, String planeModel, String planeSerialNumber,
                          double flightRange, double fuelConsumption, double weightCapacity, int seatsCapacity) {
        super(planeBrand, planeModel, planeSerialNumber, flightRange, fuelConsumption);
        this.weightCapacity = weightCapacity;
        this.seatsCapacity = seatsCapacity;
    }

    @Override
    double getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    @Override
    public int getSeatsCapacity() {
        return seatsCapacity;
    }

    @Override
    public void setSeatsCapacity(int seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }
}
