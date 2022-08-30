package by.academy.homework8.model;

abstract public class Plane {

    //region fields
    private String planeBrand;

    private String planeModel;

    private String planeSerialNumber;

    private double flightRange;

    private double fuelConsumption;
    //endregion

    public Plane(String planeBrand, String planeModel, String planeSerialNumber, double flightRange,
                 double fuelConsumption) {
        this.planeBrand = planeBrand;
        this.planeModel = planeModel;
        this.planeSerialNumber = planeSerialNumber;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
    }

    //region properties
    abstract double getWeightCapacity();

    abstract void setWeightCapacity(double weightCapacity);

    abstract public int getSeatsCapacity();

    abstract public void setSeatsCapacity(int seatsCapacity);

    public String getPlaneBrand() {
        return planeBrand;
    }

    public void setPlaneBrand(String planeBrand) {
        this.planeBrand = planeBrand;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public String getPlaneSerialNumber() {
        return planeSerialNumber;
    }

    public void setPlaneSerialNumber(String planeSerialNumber) {
        this.planeSerialNumber = planeSerialNumber;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(double flightRange) {
        this.flightRange = flightRange;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    //endregion


    @Override
    public String toString() {
        return "Plane{" +
                "planeBrand= " + planeBrand +
                ", planeModel= " + planeModel +
                ", planeSerialNumber= " + planeSerialNumber +
                ", flightRange= " + flightRange +
                ", weight capacity= " + getWeightCapacity() +
                ", seats capacity= " + getSeatsCapacity() +
                ", fuelConsumption= " + fuelConsumption +
                '}';
    }
}
