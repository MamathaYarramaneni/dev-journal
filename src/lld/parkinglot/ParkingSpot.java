package lld.parkinglot;

public class ParkingSpot {
    private final int spotNo;
    private VehicleType supportedVehicle;
    private Vehicle currentVehicle;

    ParkingSpot() {}

    ParkingSpot(int spotNo, Vehicle supportedVehicle) {
        this.spotNo = spotNo;
        this.supportedVehicle = supportedVehicle;
    }

    public boolean isAvailable() {
        return this.currentVehicle == null;
    }

    public void parkVehicle(Vehicle newVehicle) {
        if(isAvailable() && newVehicle.getType() == supportedVehicle) {
            this.currentVehicle = newVehicle;
        } else {
            throw new IllegalArgumentException("Invalid Vehicle Type or spot already occupied!");
        }
    }

    public void freeParkingSpot() {
        this.currentVehicle = null;
    }

    public VehicleType getSupportedVehicle() {
        return supportedVehicle;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public int getSpotNo() {
        return spotNo;
    }
}