import core.BusManager;
import models.*;
import utils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BusSystem {

    static Scanner scanner = new Scanner(System.in);
    static List<Booking>    bookings  = new ArrayList<>();
    static List<Ticket>     tickets   = new ArrayList<>();
    static List<BusManager> buses     = new ArrayList<>();

    // ── Duplicate ID tracking sets ─────────────────────────────────────────
    static Set<String> usedBusIds       = new HashSet<>();
    static Set<String> usedPassengerIds = new HashSet<>();
    static Set<String> usedRouteIds     = new HashSet<>();
    static Set<String> usedDriverIds    = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   WELCOME TO THE BUS MANAGEMENT SYSTEM ");
        System.out.println("========================================\n");

        // ── 1. DRIVER DETAILS ────────────────────────────────────────────────
        System.out.println("---------- DRIVER DETAILS ----------");
        String driverId      = promptUniqueId("Enter Driver ID: ", usedDriverIds);
        String driverName    = promptNonEmpty("Enter Driver Name: ");
        String licenseNumber = promptNonEmpty("Enter License Number: ");
        int    experience    = promptPositiveInt("Enter Experience (years): ");

        Driver driver = new Driver(driverId, driverName, licenseNumber, experience);
        System.out.println("\n>> Driver created: " + driver + "\n");

        // ── 2. BUS DETAILS ───────────────────────────────────────────────────
        System.out.println("---------- BUS DETAILS ----------");
        String busType   = promptBusType();
        String busId     = promptUniqueId("Enter Bus ID: ", usedBusIds);
        String busName   = promptNonEmpty("Enter Bus Name: ");
        int    capacity  = promptPositiveInt("Enter Capacity: ");
        String fuelType  = promptNonEmpty("Enter Fuel Type (e.g., Diesel/Electric): ");
        String location  = promptNonEmpty("Enter Current Location: ");
        String busNumber = promptNonEmpty("Enter Bus Number (e.g., RW-123): ");
        String routeName = promptNonEmpty("Enter Route Name: ");

        BusManager bus = BusFactory.createBus(busType, busId, busName, capacity,
                fuelType, location, "Active",
                driverName, busNumber, routeName);
        buses.add(bus);
        bus.startVehicle();
        System.out.println("\n>> Bus created: " + bus + "\n");

        // ── 3. PASSENGER DETAILS ─────────────────────────────────────────────
        System.out.println("---------- PASSENGER DETAILS ----------");
        String pId    = promptUniqueId("Enter Passenger ID: ", usedPassengerIds);
        String pName  = promptNonEmpty("Enter Passenger Name: ");
        String pPhone = promptPhone("Enter Passenger Phone: ");
        String pEmail = promptEmail("Enter Passenger Email: ");

        Passenger passenger = new Passenger(pId, pName, pPhone, pEmail);
        System.out.println("\n>> Passenger created: " + passenger + "\n");

        // ── 4. ROUTE DETAILS ─────────────────────────────────────────────────
        System.out.println("---------- ROUTE DETAILS ----------");
        String rId  = promptUniqueId("Enter Route ID: ", usedRouteIds);
        String from = promptNonEmpty("Enter Start Location: ");
        String to   = promptNonEmpty("Enter Destination: ");
        double dist = promptPositiveDouble("Enter Distance (km): ");
        String eta  = promptNonEmpty("Enter Estimated Time (e.g., 2h 30m): ");

        Route route = new Route(rId, from, to, dist, eta);
        bus.assignRoute(routeName);
        System.out.println("\n>> Route created: " + route + "\n");

        // ── 5. SCHEDULE DETAILS ──────────────────────────────────────────────
        System.out.println("---------- SCHEDULE DETAILS ----------");
        String scheduleId     = "SCH-" + System.currentTimeMillis();
        String departureTime  = promptNonEmpty("Enter Departure Time (e.g., 08:00 AM): ");
        String arrivalTime    = promptNonEmpty("Enter Arrival Time   (e.g., 10:30 AM): ");

        Schedule schedule = new Schedule(scheduleId, bus, departureTime, arrivalTime, route);
        System.out.println("\n>> Schedule created: " + schedule + "\n");

        // ── 6. BOOKING ───────────────────────────────────────────────────────
        System.out.println("---------- BOOKING ----------");
        int seatNo = promptSeat(capacity);

        String ticketId  = "TKT-" + System.currentTimeMillis();
        String bookingId = "BKG-" + System.currentTimeMillis();

        Ticket ticket = new Ticket(ticketId, passenger, bus, seatNo, dist);
        bus.bookSeat(pName, seatNo);

        Booking booking = new Booking(bookingId, passenger, ticket,
                java.time.LocalDate.now().toString());
        booking.confirmBooking();

        // ── User chooses to confirm or cancel ────────────────────────────────────
        System.out.println("\n-- BOOKING ACTION --");
        System.out.println("Booking is currently: " + booking.getStatus());
        while (true) {
            System.out.print("Do you want to CONFIRM or CANCEL this booking? (CONFIRM/CANCEL): ");
            String choice = scanner.nextLine().trim().toUpperCase();
            if (choice.equals("CONFIRM")) {
                bus.bookSeat(pName, seatNo);
                booking.confirmBooking();
                break;
            } else if (choice.equals("CANCEL")) {
                bus.cancelBooking(bookingId);
                booking.cancelBooking();
                System.out.println("Your booking has been cancelled. Exiting...");
                scanner.close();
                return; // exits the program if cancelled
            } else {
                System.out.println("  ERROR: Please type CONFIRM or CANCEL.");
            }
        }

        bookings.add(booking);
        tickets.add(ticket);

        // ── 7. PAYMENT ───────────────────────────────────────────────────────
        System.out.println("\n---------- PAYMENT ----------");
        String payMethod = promptPaymentMethod();
        String payId     = "PAY-" + System.currentTimeMillis();
        Payment payment  = new Payment(payId, ticket.getPrice(), payMethod);
        payment.processPayment();

        // ── 8. TRACKING ──────────────────────────────────────────────────────
        System.out.println("\n---------- TRACKING ----------");
        bus.trackLocation();
        bus.updateStatus("En Route");
        System.out.println("\n---------- STOPPING VEHICLE ----------");
        bus.stopVehicle();

        // ── 9. REPORTS ───────────────────────────────────────────────────────
        System.out.println("\n========================================");
        System.out.println("            SYSTEM REPORTS              ");
        System.out.println("========================================");
        ReportGenerator.generateBookingReport(bookings);
        ReportGenerator.generateRevenueReport(tickets);
        ReportGenerator.generateBusUsageReport(buses);
        ReportGenerator.generatePassengerStatistics(bookings);

        // ── 10. MAINTENANCE ──────────────────────────────────────────────────────────
        System.out.println("\n---------- MAINTENANCE ----------");
        String maintDate = promptNonEmpty("Enter Maintenance Date (e.g., 2026-05-01): ");
        String maintDesc = promptNonEmpty("Enter Maintenance Description: ");
        Maintenance maintenance = new Maintenance("MNT-001", bus, maintDate, maintDesc);
        maintenance.scheduleMaintenance(maintDate, maintDesc);
        System.out.println(">> " + maintenance);

        // ── 10. FINAL SUMMARY ────────────────────────────────────────────────
        System.out.println("============= FINAL SUMMARY =============");
        System.out.println(driver);
        System.out.println(bus);
        System.out.println(passenger);
        System.out.println(route);
        System.out.println(schedule);
        System.out.println(ticket);
        System.out.println(booking);
        System.out.println(payment);
        System.out.println(maintenance);
        System.out.println("=========================================");

        scanner.close();
    }

    // ── HELPER INPUT METHODS ─────────────────────────────────────────────────

    static String promptBusType() {
        while (true) {
            System.out.print("Enter Bus Type (CITY/EXPRESS/LUXURY/SCHOOL/TOURIST/ELECTRIC): ");
            String input = scanner.nextLine().trim();
            if (InputValidator.isValidBusType(input)) return input;
            System.out.println("  ERROR: Invalid bus type. Choose from: CITY, EXPRESS, LUXURY, SCHOOL, TOURIST, ELECTRIC.");
        }
    }

    static String promptNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            String error = InputValidator.validateNotEmpty(input, prompt);
            if (error == null) return input;
            System.out.println("  ERROR: " + error);
        }
    }

    // ── NEW: unique ID prompt uses the set to block duplicates ───────────────
    static String promptUniqueId(String prompt, Set<String> usedIds) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (InputValidator.isNullOrEmpty(input)) {
                System.out.println("  ERROR: ID cannot be empty.");
            } else if (!InputValidator.isValidId(input)) {
                System.out.println("  ERROR: ID must be 3–20 alphanumeric characters (letters, digits, - or _).");
            } else if (InputValidator.isDuplicateId(input, usedIds)) {
                System.out.println("  ERROR: ID '" + input + "' already exists. Please enter a unique ID.");
            } else {
                usedIds.add(input); // register it
                return input;
            }
        }
    }

    static int promptPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            String error = InputValidator.validatePositiveInt(input, prompt);
            if (error == null) return Integer.parseInt(input);
            System.out.println("  ERROR: " + error);
        }
    }

    static double promptPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            String error = InputValidator.validatePositiveDouble(input, prompt);
            if (error == null) return Double.parseDouble(input);
            System.out.println("  ERROR: " + error);
        }
    }

    static String promptPhone(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            String error = InputValidator.validatePhone(input);
            if (error == null) return input;
            System.out.println("  ERROR: " + error);
        }
    }

    static String promptEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            String error = InputValidator.validateEmail(input);
            if (error == null) return input;
            System.out.println("  ERROR: " + error);
        }
    }

    static int promptSeat(int capacity) {
        while (true) {
            System.out.print("Enter Seat Number (1–" + capacity + "): ");
            String input = scanner.nextLine().trim();
            try {
                int seat = Integer.parseInt(input);
                if (seat >= 1 && seat <= capacity) return seat;
                System.out.println("  ERROR: Seat must be between 1 and " + capacity + ".");
            } catch (NumberFormatException e) {
                System.out.println("  ERROR: Enter a valid whole number for seat.");
            }
        }
    }

    static String promptPaymentMethod() {
        while (true) {
            System.out.print("Enter Payment Method (CASH/CARD/MOBILE): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("CASH") || input.equals("CARD") || input.equals("MOBILE"))
                return input;
            System.out.println("  ERROR: Choose CASH, CARD, or MOBILE.");
        }
    }
}