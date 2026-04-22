package core;

import interfaces.Bookable;
import interfaces.Trackable;

public class BusManager extends Vehicle implements Bookable, Trackable {
    private String driverName;
    private String busNumber;
    private String routeAssigned;
    private int bookedSeats;

    // Default constructor
    public BusManager() {
        super();
        this.driverName = "Unassigned";
        this.busNumber  = "BUS-000";
        this.routeAssigned = "No Route";
        this.bookedSeats = 0;
    }

    // Parameterized constructor
    public BusManager(String vehicleId, String vehicleName, int capacity,
                      String fuelType, String currentLocation, String status,
                      String driverName, String busNumber, String routeAssigned) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status);
        this.driverName    = driverName;
        this.busNumber     = busNumber;
        this.routeAssigned = routeAssigned;
        this.bookedSeats   = 0;
    }

    // Getters & Setters
    public String getDriverName()    { return driverName; }
    public String getBusNumber()     { return busNumber; }
    public String getRouteAssigned() { return routeAssigned; }
    public int getBookedSeats()      { return bookedSeats; }

    public void setDriverName(String driverName)       { this.driverName = driverName; }
    public void setBusNumber(String busNumber)         { this.busNumber = busNumber; }
    public void setRouteAssigned(String routeAssigned) { this.routeAssigned = routeAssigned; }

    // ── Vehicle abstract methods ──────────────────────────────────────────────
    @Override
    public void startVehicle() {
        setStatus("Running");
        System.out.println(getBusNumber() + " has started.");
    }

    @Override
    public void stopVehicle() {
        setStatus("Stopped");
        System.out.println(getBusNumber() + " has stopped.");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        double rate = 0.15; // litres per km (default)
        return distance * rate;
    }

    @Override
    public boolean checkAvailability() {
        return bookedSeats < getCapacity();
    }

    @Override
    public void assignRoute(String routeName) {
        this.routeAssigned = routeName;
        System.out.println(getBusNumber() + " assigned to route: " + routeName);
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println(getBusNumber() + " location updated to: " + newLocation);
    }

    @Override
    public void performMaintenanceCheck() {
        System.out.println("Maintenance check performed on " + getBusNumber());
    }

    @Override
    public String generateVehicleReport() {
        return "Report [" + getBusNumber() + "]: Route=" + routeAssigned +
                ", Capacity=" + getCapacity() + ", Booked=" + bookedSeats +
                ", Status=" + getStatus();
    }

    // ── Bookable ──────────────────────────────────────────────────────────────
    @Override
    public void bookSeat(String passengerName, int seatNumber) {
        if (!checkAvailability()) {
            System.out.println("ERROR: Bus " + getBusNumber() + " is fully booked.");
            return;
        }
        bookedSeats++;
        System.out.println("Seat " + seatNumber + " booked for " + passengerName +
                " on bus " + getBusNumber());
    }

    @Override
    public void cancelBooking(String bookingId) {
        if (bookedSeats > 0) bookedSeats--;
        System.out.println("Booking " + bookingId + " cancelled on bus " + getBusNumber());
    }

    @Override
    public double calculateFare(double distance) {
        return distance * 0.5; // $0.50 per km (base rate)
    }

    // ── Trackable ─────────────────────────────────────────────────────────────
    @Override
    public void trackLocation() {
        System.out.println(getBusNumber() + " is currently at: " + getCurrentLocation());
    }

    @Override
    public void updateStatus(String newStatus) {
        setStatus(newStatus);
        System.out.println(getBusNumber() + " status updated to: " + newStatus);
    }

    @Override
    public String toString() {
        return "BusManager{" + super.toString() +
                ", Driver='" + driverName + "', BusNo='" + busNumber +
                "', Route='" + routeAssigned + "', Booked=" + bookedSeats + "}";
    }
}