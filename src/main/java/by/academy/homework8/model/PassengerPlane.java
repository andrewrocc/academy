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

    public PassengerPlane() {
        super();
    }

    //region prop
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
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane that)) return false;
        if (!super.equals(o)) return false;

        if (Double.compare(that.weightCapacity, weightCapacity) != 0) return false;
        return seatsCapacity == that.seatsCapacity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(weightCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + seatsCapacity;
        return result;
    }
}
