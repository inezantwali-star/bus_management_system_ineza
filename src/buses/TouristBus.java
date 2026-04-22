package buses;

import core.BusManager;

public class TouristBus extends BusManager {
    private String tourPackage;

    public TouristBus() {
        super();
        this.tourPackage = "Standard Tour";
    }

    public TouristBus(String vehicleId, String vehicleName, int capacity,
                      String fuelType, String currentLocation, String status,
                      String driverName, String busNumber, String routeAssigned,
                      String tourPackage) {
        super(vehicleId, vehicleName, capacity, fuelType,
                currentLocation, status, driverName, busNumber, routeAssigned);
        this.tourPackage = tourPackage;
    }

    public String getTourPackage() { return tourPackage; }
    public void setTourPackage(String tourPackage) { this.tourPackage = tourPackage; }

    @Override
    public void startVehicle() {
        setStatus("Running");
        System.out.println("TouristBus " + getBusNumber() + " started — Package: " + tourPackage);
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.17;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 1.0;
    }

    @Override
    public String generateVehicleReport() {
        return "TouristBus Report [" + getBusNumber() + "]: Package=" + tourPackage +
                ", " + super.generateVehicleReport();
    }

    @Override
    public String toString() {
        return "TouristBus{" + super.toString() + ", Package='" + tourPackage + "'}";
    }
}