package buses;

import core.BusManager;

public class ElectricBus extends BusManager {
    private double batteryCapacityKWh;

    public ElectricBus() {
        super();
        this.batteryCapacityKWh = 0.0;
    }

    public ElectricBus(String vehicleId, String vehicleName, int capacity,
                       String fuelType, String currentLocation, String status,
                       String driverName, String busNumber, String routeAssigned,
                       double batteryCapacityKWh) {
        super(vehicleId, vehicleName, capacity, fuelType,
                currentLocation, status, driverName, busNumber, routeAssigned);
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    public double getBatteryCapacityKWh() { return batteryCapacityKWh; }
    public void setBatteryCapacityKWh(double v) { this.batteryCapacityKWh = v; }

    @Override
    public void startVehicle() {
        setStatus("Running");
        System.out.println("ElectricBus " + getBusNumber() + " started silently — Battery: " +
                batteryCapacityKWh + " kWh");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.02; // kWh per km (not fuel, but energy)
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 0.45; // eco-friendly discount
    }

    @Override
    public String generateVehicleReport() {
        return "ElectricBus Report [" + getBusNumber() + "]: Battery=" +
                batteryCapacityKWh + "kWh, " + super.generateVehicleReport();
    }

    @Override
    public String toString() {
        return "ElectricBus{" + super.toString() + ", Battery=" + batteryCapacityKWh + "kWh}";
    }
}