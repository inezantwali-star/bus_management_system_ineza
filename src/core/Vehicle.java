package core;

public abstract class Vehicle {
    private String vehicleId;
    private String vehicleName;
    private int capacity;
    private String fuelType;
    private String currentLocation;
    private String status;

    // Default constructor
    public Vehicle() {
        this.vehicleId = "V000";
        this.vehicleName = "Unknown";
        this.capacity = 0;
        this.fuelType = "Unknown";
        this.currentLocation = "Depot";
        this.status = "Idle";
    }

    // Parameterized constructor
    public Vehicle(String vehicleId, String vehicleName, int capacity,
                   String fuelType, String currentLocation, String status) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.capacity = capacity;
        this.fuelType = fuelType;
        this.currentLocation = currentLocation;
        this.status = status;
    }

    // Getters
    public String getVehicleId()       { return vehicleId; }
    public String getVehicleName()     { return vehicleName; }
    public int getCapacity()           { return capacity; }
    public String getFuelType()        { return fuelType; }
    public String getCurrentLocation() { return currentLocation; }
    public String getStatus()          { return status; }

    // Setters
    public void setVehicleId(String vehicleId)             { this.vehicleId = vehicleId; }
    public void setVehicleName(String vehicleName)         { this.vehicleName = vehicleName; }
    public void setCapacity(int capacity)                  { this.capacity = capacity; }
    public void setFuelType(String fuelType)               { this.fuelType = fuelType; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }
    public void setStatus(String status)                   { this.status = status; }

    // Abstract methods
    public abstract void startVehicle();
    public abstract void stopVehicle();
    public abstract double calculateFuelConsumption(double distance);
    public abstract boolean checkAvailability();
    public abstract void assignRoute(String routeName);
    public abstract void updateLocation(String newLocation);
    public abstract void performMaintenanceCheck();
    public abstract String generateVehicleReport();

    @Override
    public String toString() {
        return "Vehicle{" +
                "ID='" + vehicleId + "', Name='" + vehicleName +
                "', Capacity=" + capacity + ", Fuel='" + fuelType +
                "', Location='" + currentLocation + "', Status='" + status + "'}";
    }
}