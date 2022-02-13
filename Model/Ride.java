package Model;

import java.util.UUID;



public class Ride {

    private String rideId;
    private String userId;
    private String driverId;
    private RideStatus status;
    private Double earnings;
    private Location from;
    private Location to;

    public Ride(String userId, String driverId, Location from, Location to) {
        String uuid = UUID.randomUUID().toString();
        this.rideId = uuid;
        this.userId = userId;
        this.driverId = driverId;
        this.status = RideStatus.ONGOING;
        this.from = from;
        this.to = to;
    }

    public String getRideId() {
        return rideId;
    }

    public String getUserId() {
        return userId;
    }

    public String getDriverId() {
        return driverId;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public Double getEarnings() {
        return earnings;
    }

    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }

    public Location getFrom() {
        return from;
    }


    public Location getTo() {
        return to;
    }

    
    



    


    
}
