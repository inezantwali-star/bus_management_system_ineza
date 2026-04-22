package models;

public class Booking {
    private String bookingId;
    private Passenger passenger;
    private Ticket ticket;
    private String bookingDate;
    private String status; // CONFIRMED, CANCELLED, PENDING

    public Booking() {}

    public Booking(String bookingId, Passenger passenger, Ticket ticket, String bookingDate) {
        this.bookingId   = bookingId;
        this.passenger   = passenger;
        this.ticket      = ticket;
        this.bookingDate = bookingDate;
        this.status      = "PENDING";
    }

    public void confirmBooking() {
        this.status = "CONFIRMED";
        System.out.println("Booking " + bookingId + " CONFIRMED for " + passenger.getName());
    }

    public void cancelBooking() {
        this.status = "CANCELLED";
        System.out.println("Booking " + bookingId + " CANCELLED for " + passenger.getName());
    }

    public String getBookingId()   { return bookingId; }
    public Passenger getPassenger(){ return passenger; }
    public Ticket getTicket()      { return ticket; }
    public String getBookingDate() { return bookingDate; }
    public String getStatus()      { return status; }

    public void setBookingId(String id)     { this.bookingId = id; }
    public void setPassenger(Passenger p)   { this.passenger = p; }
    public void setTicket(Ticket t)         { this.ticket = t; }
    public void setBookingDate(String date) { this.bookingDate = date; }
    public void setStatus(String status)    { this.status = status; }

    @Override
    public String toString() {
        return "Booking{ID='" + bookingId + "', Passenger=" + passenger.getName() +
                ", Ticket=" + ticket.getTicketId() + ", Date='" + bookingDate +
                "', Status='" + status + "'}";
    }
}