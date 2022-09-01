package by.academy.homework8.model;

public class WideBodyPlane extends Plane {

    private int seatsCapacity;

    public WideBodyPlane(String planeBrand, String planeModel, String planeSerialNumber,
                         double flightRange, double fuelConsumption, int seatsCapacity) {
        super(planeBrand, planeModel, planeSerialNumber, flightRange, fuelConsumption);
        this.seatsCapacity = seatsCapacity;
    }

    public WideBodyPlane() {
        super();
    }

    //region prop
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
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WideBodyPlane that)) return false;
        if (!super.equals(o)) return false;

        return seatsCapacity == that.seatsCapacity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + seatsCapacity;
        return result;
    }
}
