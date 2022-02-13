package Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.Driver;
import Model.Location;
import Model.Ride;
import Model.RideStatus;

public class RideRepo {
    private static RideRepo rideRepo = new RideRepo();
    private Map<String, Ride> allRides;

    private RideRepo() {
        allRides = new HashMap<String, Ride>();
    }

    public static RideRepo makeRideRepo(){
        return rideRepo;
    }

    public Map<String, Ride> getAllRides() {
        return allRides; 
    }
    
    public Ride getRideById(String rideId) {
        if(!allRides.containsKey(rideId)) {
            System.out.println("The ride isn't present");
            return null;
        }
        return allRides.get(rideId);
    }

    
    public void addRide(Ride ride) {
        allRides.put(ride.getRideId(), ride);
    }

    public Double updateEarnings(Ride ride, Driver driver) {
        Location from = ride.getFrom();
        Location to = ride.getTo();
        Double dist = from.distance(to);
        Double vehicleCostPerKm = driver.getVehicle().getCostPerKilo();
        Double totalCost = dist * vehicleCostPerKm;
        ride.setEarnings(totalCost);
        driver.addEarnings(totalCost);
        return totalCost;
    }


}
