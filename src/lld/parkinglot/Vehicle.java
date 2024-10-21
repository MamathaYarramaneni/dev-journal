package lld.parkinglot;

public class Vehicle {
    protected VehicleType type;
    protected String numberPlate;

    Vehicle() {}

    Vehicle(VehicleType type, String numberPlate) {
        this.type = type;
        this.numberPlate = numberPlate;
    }

    public VehicleType getType() {
        return type;
    }
}