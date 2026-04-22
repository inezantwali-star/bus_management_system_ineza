package utils;

import models.Booking;
import models.Ticket;
import core.BusManager;
import java.util.List;

public class ReportGenerator {

    public static void generateBookingReport(List<Booking> bookings) {
        System.out.println("\n===== DAILY BOOKING REPORT =====");
        if (bookings.isEmpty()) {
            System.out.println("No bookings today.");
        } else {
            for (Booking b : bookings) System.out.println(b);
        }
        System.out.println("Total Bookings: " + bookings.size());
        System.out.println("=================================\n");
    }

    public static void generateRevenueReport(List<Ticket> tickets) {
        System.out.println("\n===== REVENUE REPORT =====");
        double total = 0;
        for (Ticket t : tickets) {
            System.out.println(t);
            total += t.getPrice();
        }
        System.out.printf("Total Revenue: $%.2f%n", total);
        System.out.println("==========================\n");
    }

    public static void generateBusUsageReport(List<BusManager> buses) {
        System.out.println("\n===== BUS USAGE REPORT =====");
        for (BusManager b : buses) {
            System.out.println(b.generateVehicleReport());
        }
        System.out.println("============================\n");
    }

    public static void generatePassengerStatistics(List<Booking> bookings) {
        System.out.println("\n===== PASSENGER STATISTICS =====");
        System.out.println("Total Passengers Served: " + bookings.size());
        long confirmed = bookings.stream()
                .filter(b -> b.getStatus().equals("CONFIRMED")).count();
        long cancelled = bookings.stream()
                .filter(b -> b.getStatus().equals("CANCELLED")).count();
        System.out.println("Confirmed: " + confirmed);
        System.out.println("Cancelled: " + cancelled);
        System.out.println("================================\n");
    }
}