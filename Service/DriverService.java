package Service;

import java.util.Map;
import java.util.Map.Entry;

import Model.Driver;
import Model.Location;
import Model.Ride;
import Model.RideStatus;
import Repository.DriverRepo;
import Repository.RideRepo;

public class DriverService {
    private DriverRepo driverRepository;
    private RideRepo rideRepository;

    public DriverService(DriverRepo driverRepository, RideRepo rideRepository) {
        this.driverRepository = driverRepository;
        this.rideRepository = rideRepository;
    }

    public void addDriver(Driver driver) {
        driverRepository.addDriver(driver);
    }

    public void updateDriverLocation(String driverId, Location location) {
        Driver driver = driverRepository.getDriverById(driverId);
        driver.setCurrentLocation(location);
    }

    public void changeDriverStatus(String driverId, boolean status) {
        Driver driver = driverRepository.getDriverById(driverId);
        driver.setAvailable(status);
    }

    public void completeBooking(String rideId) {
        Ride ride = rideRepository.getRideById(rideId);
        RideStatus status = RideStatus.COMPLETED;
        ride.setStatus(status);
    }

    public void findTotalEarnings() {
        driverRepository.getAllDriversEarnings();
    }

}
