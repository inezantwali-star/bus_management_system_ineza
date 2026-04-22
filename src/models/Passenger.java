package models;

public class Passenger {
    private String passengerId;
    private String name;
    private String phoneNumber;
    private String email;

    public Passenger() {}

    public Passenger(String passengerId, String name, String phoneNumber, String email) {
        this.passengerId = passengerId;
        this.name        = name;
        this.phoneNumber = phoneNumber;
        this.email       = email;
    }

    public String getPassengerId() { return passengerId; }
    public String getName()        { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail()       { return email; }

    public void setPassengerId(String id)       { this.passengerId = id; }
    public void setName(String name)            { this.name = name; }
    public void setPhoneNumber(String phone)    { this.phoneNumber = phone; }
    public void setEmail(String email)          { this.email = email; }

    @Override
    public String toString() {
        return "Passenger{ID='" + passengerId + "', Name='" + name +
                "', Phone='" + phoneNumber + "', Email='" + email + "'}";
    }
}