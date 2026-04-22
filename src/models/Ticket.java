package models;

import core.BusManager;

public class Ticket {
    private String ticketId;
    private Passenger passenger;
    private BusManager bus;
    private int seatNumber;
    private double price;

    public Ticket() {}

    public Ticket(String ticketId, Passenger passenger, BusManager bus,
                  int seatNumber, double distance) {
        this.ticketId   = ticketId;
        this.passenger  = passenger;
        this.bus        = bus;
        this.seatNumber = seatNumber;
        this.price      = calculateTicketPrice(distance);
    }

    public double calculateTicketPrice(double distance) {
        return bus.calculateFare(distance);
    }

    public String getTicketId()    { return ticketId; }
    public Passenger getPassenger(){ return passenger; }
    public BusManager getBus()     { return bus; }
    public int getSeatNumber()     { return seatNumber; }
    public double getPrice()       { return price; }

    public void setTicketId(String id)       { this.ticketId = id; }
    public void setPassenger(Passenger p)    { this.passenger = p; }
    public void setBus(BusManager b)         { this.bus = b; }
    public void setSeatNumber(int seat)      { this.seatNumber = seat; }
    public void setPrice(double price)       { this.price = price; }

    @Override
    public String toString() {
        return "Ticket{ID='" + ticketId + "', Passenger=" + passenger.getName() +
                ", Bus=" + bus.getBusNumber() + ", Seat=" + seatNumber +
                ", Price=$" + String.format("%.2f", price) + "}";
    }
}