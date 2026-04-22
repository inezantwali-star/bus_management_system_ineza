package buses;

import core.BusManager;

public class ExpressBus extends BusManager {
    private int numberOfStops;

    public ExpressBus() {
        super();
        this.numberOfStops = 0;
    }

    public ExpressBus(String vehicleId, String vehicleName, int capacity,
                      String fuelType, String currentLocation, String status,
                      String driverName, String busNumber, String routeAssigned,
                      int numberOfStops) {
        super(vehicleId, vehicleName, capacity, fuelType,
                currentLocation, status, driverName, busNumber, routeAssigned);
        this.numberOfStops = numberOfStops;
    }

    public int getNumberOfStops() { return numberOfStops; }
    public void setNumberOfStops(int n) { this.numberOfStops = n; }

    @Override
    public void startVehicle() {
        setStatus("Running");
        System.out.println("ExpressBus " + getBusNumber() + " started — limited stops: " + numberOfStops);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.18; // faster = more fuel
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 0.7; // premium for speed
    }

    @Override
    public String generateVehicleReport() {
        return "ExpressBus Report [" + getBusNumber() + "]: Stops=" + numberOfStops +
                ", " + super.generateVehicleReport();
    }

    @Override
    public String toString() {
        return "ExpressBus{" + super.toString() + ", Stops=" + numberOfStops + "}";
    }
}