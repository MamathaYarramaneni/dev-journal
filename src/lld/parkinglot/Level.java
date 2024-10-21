package lld.parkinglot;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Level {
    private int floor;
    private List<ParkingSpot> parkingSpots;

    Level(int floor, int numSpots) {
        this.floor = floor;

        this.parkingSpots = new ArrayList<>(numSpots);

        for(int i = 1; i <= numSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getSupportedVehicle() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getSupportedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public ArrayList<ParkingSpot> getParkingSpots() {
        return this.parkingSpots;
    }

    public ArrayList<ParkingSpot> getAvailableParkingSpots() {
        return this.parkingSpots
                .stream()
                .filter(ps -> ps.isAvailable())
                .collect(Collectors.toList());
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }

}