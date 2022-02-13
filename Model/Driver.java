package Model;

import java.util.UUID;

public class Driver extends People {

    private String driverId;
    private Vehicle vehicle;
    private Location currentLocation;
    private boolean isAvailable;
    private Double earnings;
    

    public Double getEarnings() {
        return earnings;
    }



    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }



    public Driver(String name, GenderEnum gender, int age, Vehicle vehicle, Location location) {
        super(name, gender, age);
        String uuid = UUID.randomUUID().toString();
        this.driverId = uuid;

        this.vehicle = vehicle;
        this.currentLocation = location;
        isAvailable = true;
        this.earnings = 0.0;
    }
    
    

    public boolean isAvailable() {
        return isAvailable;
    }



    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }



    public Vehicle getVehicle() {
        return vehicle;
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public String getDriverId() {
        return this.driverId;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }


    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void addEarnings(Double newEarnings) {
        this.earnings = this.earnings + newEarnings;
    }

    public String toString() {
        String driverInfo = this.name + " " + (this.isAvailable ? "is Available" : "");
        return driverInfo;
    }
}
