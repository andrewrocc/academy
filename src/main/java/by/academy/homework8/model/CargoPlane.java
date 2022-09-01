package by.academy.homework8.model;

public class CargoPlane extends Plane  {

    private double weightCapacity;

    public CargoPlane(String planeBrand, String planeModel, String planeSerialNumber,
                      double flightRange, double fuelConsumption, double weightCapacity) {
        super(planeBrand, planeModel, planeSerialNumber, flightRange, fuelConsumption);
        this.weightCapacity = weightCapacity;
    }

    public CargoPlane() {
        super();
    }

    //region prop
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
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CargoPlane that)) return false;
        if (!super.equals(o)) return false;

        return Double.compare(that.weightCapacity, weightCapacity) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(weightCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
