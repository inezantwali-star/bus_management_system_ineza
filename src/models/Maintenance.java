package models;

import core.Vehicle;

public class Maintenance {
    private String maintenanceId;
    private Vehicle vehicle;
    private String maintenanceDate;
    private String description;

    public Maintenance() {}

    public Maintenance(String maintenanceId, Vehicle vehicle,
                       String maintenanceDate, String description) {
        this.maintenanceId   = maintenanceId;
        this.vehicle         = vehicle;
        this.maintenanceDate = maintenanceDate;
        this.description     = description;
    }

    public void scheduleMaintenance(String date, String desc) {
        this.maintenanceDate = date;
        this.description     = desc;
        System.out.println("Maintenance scheduled for " + vehicle.getVehicleId() +
                " on " + date + ": " + desc);
    }

    public String getMaintenanceId()   { return maintenanceId; }
    public Vehicle getVehicle()        { return vehicle; }
    public String getMaintenanceDate() { return maintenanceDate; }
    public String getDescription()     { return description; }

    public void setMaintenanceId(String id)      { this.maintenanceId = id; }
    public void setVehicle(Vehicle v)            { this.vehicle = v; }
    public void setMaintenanceDate(String date)  { this.maintenanceDate = date; }
    public void setDescription(String desc)      { this.description = desc; }

    @Override
    public String toString() {
        return "Maintenance{ID='" + maintenanceId + "', Vehicle=" + vehicle.getVehicleId() +
                ", Date='" + maintenanceDate + "', Description='" + description + "'}";
    }
}