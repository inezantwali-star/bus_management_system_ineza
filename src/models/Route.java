package models;

public class Route {
    private String routeId;
    private String startLocation;
    private String destination;
    private double distance;
    private String estimatedTime;

    public Route() {}

    public Route(String routeId, String startLocation, String destination,
                 double distance, String estimatedTime) {
        this.routeId       = routeId;
        this.startLocation = startLocation;
        this.destination   = destination;
        this.distance      = distance;
        this.estimatedTime = estimatedTime;
    }

    public String getRouteId()        { return routeId; }
    public String getStartLocation()  { return startLocation; }
    public String getDestination()    { return destination; }
    public double getDistance()       { return distance; }
    public String getEstimatedTime()  { return estimatedTime; }

    public void setRouteId(String id)              { this.routeId = id; }
    public void setStartLocation(String start)     { this.startLocation = start; }
    public void setDestination(String dest)        { this.destination = dest; }
    public void setDistance(double distance)       { this.distance = distance; }
    public void setEstimatedTime(String time)      { this.estimatedTime = time; }

    @Override
    public String toString() {
        return "Route{ID='" + routeId + "', From='" + startLocation +
                "', To='" + destination + "', Distance=" + distance +
                "km, ETA='" + estimatedTime + "'}";
    }
}