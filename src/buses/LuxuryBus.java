package buses;

import core.BusManager;

public class LuxuryBus extends BusManager {
    private boolean hasWifi;

    public LuxuryBus() {
        super();
        this.hasWifi = false;
    }

    public LuxuryBus(String vehicleId, String vehicleName, int capacity,
                     String fuelType, String currentLocation, String status,
                     String driverName, String busNumber, String routeAssigned,
                     boolean hasWifi) {
        super(vehicleId, vehicleName, capacity, fuelType,
                currentLocation, status, driverName, busNumber, routeAssigned);
        this.hasWifi = hasWifi;
    }

    public boolean isHasWifi() { return hasWifi; }
    public void setHasWifi(boolean v) { this.hasWifi = v; }

    @Override
    public void startVehicle() {
        setStatus("Running");
        System.out.println("LuxuryBus " + getBusNumber() + " started — WiFi: " + (hasWifi ? "ON" : "OFF"));
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.2; // heavier vehicle
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 1.2; // luxury premium
    }

    @Override
    public String generateVehicleReport() {
        return "LuxuryBus Report [" + getBusNumber() + "]: WiFi=" + hasWifi +
                ", " + super.generateVehicleReport();
    }

    @Override
    public String toString() {
        return "LuxuryBus{" + super.toString() + ", WiFi=" + hasWifi + "}";
    }
}