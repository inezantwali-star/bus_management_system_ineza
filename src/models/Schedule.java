package models;

import core.BusManager;

public class Schedule {
    private String scheduleId;
    private BusManager bus;
    private String departureTime;
    private String arrivalTime;
    private Route route;

    public Schedule() {}

    public Schedule(String scheduleId, BusManager bus, String departureTime,
                    String arrivalTime, Route route) {
        this.scheduleId    = scheduleId;
        this.bus           = bus;
        this.departureTime = departureTime;
        this.arrivalTime   = arrivalTime;
        this.route         = route;
    }

    public String getScheduleId()    { return scheduleId; }
    public BusManager getBus()       { return bus; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime()   { return arrivalTime; }
    public Route getRoute()          { return route; }

    public void setScheduleId(String id)        { this.scheduleId = id; }
    public void setBus(BusManager bus)          { this.bus = bus; }
    public void setDepartureTime(String time)   { this.departureTime = time; }
    public void setArrivalTime(String time)     { this.arrivalTime = time; }
    public void setRoute(Route route)           { this.route = route; }

    @Override
    public String toString() {
        return "Schedule{ID='" + scheduleId + "', Bus=" + bus.getBusNumber() +
                ", Departs='" + departureTime + "', Arrives='" + arrivalTime +
                "', Route=" + route.getRouteId() + "}";
    }
}