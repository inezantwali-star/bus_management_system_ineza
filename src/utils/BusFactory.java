package utils;

import buses.*;
import core.BusManager;

public class BusFactory {

    /**
     * Creates the correct bus subclass based on the type string.
     * Demonstrates polymorphism — caller uses BusManager reference.
     */
    public static BusManager createBus(String type, String vehicleId, String vehicleName,
                                       int capacity, String fuelType,
                                       String location, String status,
                                       String driverName, String busNumber, String route) {
        switch (type.toUpperCase()) {
            case "CITY":
                return new CityBus(vehicleId, vehicleName, capacity, fuelType,
                        location, status, driverName, busNumber, route, true);
            case "EXPRESS":
                return new ExpressBus(vehicleId, vehicleName, capacity, fuelType,
                        location, status, driverName, busNumber, route, 5);
            case "LUXURY":
                return new LuxuryBus(vehicleId, vehicleName, capacity, fuelType,
                        location, status, driverName, busNumber, route, true);
            case "SCHOOL":
                return new SchoolBus(vehicleId, vehicleName, capacity, fuelType,
                        location, status, driverName, busNumber, route, "Central School");
            case "TOURIST":
                return new TouristBus(vehicleId, vehicleName, capacity, fuelType,
                        location, status, driverName, busNumber, route, "City Tour");
            case "ELECTRIC":
                return new ElectricBus(vehicleId, vehicleName, capacity, fuelType,
                        location, status, driverName, busNumber, route, 300.0);
            default:
                throw new IllegalArgumentException("Unknown bus type: " + type);
        }
    }
}