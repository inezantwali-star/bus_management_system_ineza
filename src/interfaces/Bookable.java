package interfaces;

public interface Bookable {
    void bookSeat(String passengerName, int seatNumber);
    void cancelBooking(String bookingId);
    double calculateFare(double distance);
}