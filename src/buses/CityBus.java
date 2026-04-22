package buses;

import core.BusManager;

public class CityBus extends BusManager {
    private boolean hasAirConditioning;

    public CityBus() {
        super();
        this.hasAirConditioning = false;
    }

    public CityBus(String vehicleId, String vehicleName, int capacity,
                   String fuelType, String currentLocation, String status,
                   String driverName, String busNumber, String routeAssigned,
                   boolean hasAirConditioning) {
        super(vehicleId, vehicleName, capacity, fuelType,
                currentLocation, status, driverName, busNumber, routeAssigned);
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean isHasAirConditioning() { return hasAirConditioning; }
    public void setHasAirConditioning(boolean v) { this.hasAirConditioning = v; }

    @Override
    public void startVehicle() {
        setStatus("Running");
        System.out.println("CityBus " + getBusNumber() + " started its urban route.");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.12; // city buses are more efficient per stop
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 0.4; // cheaper city fare
    }

    @Override
    public String generateVehicleReport() {
        return "CityBus Report [" + getBusNumber() + "]: AC=" + hasAirConditioning +
                ", " + super.generateVehicleReport();
    }

    @Override
    public String toString() {
        return "CityBus{" + super.toString() + ", AC=" + hasAirConditioning + "}";
    }
}