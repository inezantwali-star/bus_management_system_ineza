package buses;

import core.BusManager;

public class SchoolBus extends BusManager {
    private String schoolName;

    public SchoolBus() {
        super();
        this.schoolName = "Unknown School";
    }

    public SchoolBus(String vehicleId, String vehicleName, int capacity,
                     String fuelType, String currentLocation, String status,
                     String driverName, String busNumber, String routeAssigned,
                     String schoolName) {
        super(vehicleId, vehicleName, capacity, fuelType,
                currentLocation, status, driverName, busNumber, routeAssigned);
        this.schoolName = schoolName;
    }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    @Override
    public void startVehicle() {
        setStatus("Running");
        System.out.println("SchoolBus " + getBusNumber() + " for " + schoolName + " has departed.");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.14;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 0.2; // subsidised school fare
    }

    @Override
    public String generateVehicleReport() {
        return "SchoolBus Report [" + getBusNumber() + "]: School=" + schoolName +
                ", " + super.generateVehicleReport();
    }

    @Override
    public String toString() {
        return "SchoolBus{" + super.toString() + ", School='" + schoolName + "'}";
    }
}