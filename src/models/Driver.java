package models;

public class Driver {
    private String driverId;
    private String name;
    private String licenseNumber;
    private int experienceYears;

    public Driver() {}

    public Driver(String driverId, String name, String licenseNumber, int experienceYears) {
        this.driverId        = driverId;
        this.name            = name;
        this.licenseNumber   = licenseNumber;
        this.experienceYears = experienceYears;
    }

    public String getDriverId()      { return driverId; }
    public String getName()          { return name; }
    public String getLicenseNumber() { return licenseNumber; }
    public int getExperienceYears()  { return experienceYears; }

    public void setDriverId(String id)           { this.driverId = id; }
    public void setName(String name)             { this.name = name; }
    public void setLicenseNumber(String license) { this.licenseNumber = license; }
    public void setExperienceYears(int years)    { this.experienceYears = years; }

    @Override
    public String toString() {
        return "Driver{ID='" + driverId + "', Name='" + name +
                "', License='" + licenseNumber + "', Experience=" + experienceYears + "yrs}";
    }
}