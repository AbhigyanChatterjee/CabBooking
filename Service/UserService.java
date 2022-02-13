package Service;

import java.util.List;

import Model.Driver;
import Model.Location;
import Model.Ride;
import Model.User;
import Repository.DriverRepo;
import Repository.RideRepo;
import Repository.UserRepo;

public class UserService {
    private UserRepo userRepository;
    private RideRepo rideRepository;
    private DriverRepo driverRepository;
    private final Double MAX_DISTANCE = 5.0;
    private Location from;
    private Location to;
    private List<Driver> allAvailableDrives;
    private Ride currentRide;
    

    public UserService(UserRepo userRepository, RideRepo rideRepository, DriverRepo driverRepository) {
        this.userRepository = userRepository;
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void updateUser(String userId, String contact) {
        User user = userRepository.getUserById(userId);
        user.setContact(contact);
    }

    public void updateUserLocation(String userId, Location location) {
        User user = userRepository.getUserById(userId);
        user.setLocation(location);
    }

    public List<Driver> findRide(String userId, Location from, Location to) {
        this.from = from;
        this.to = to;
        User user = userRepository.getUserById(userId);
        user.setLocation(from);
        allAvailableDrives = driverRepository.getAllAvailableDrivers(user.getLocation(), MAX_DISTANCE);
        if(allAvailableDrives.size() == 0) {
            System.out.println("No driver is available near your location");
            return allAvailableDrives;
        } 
        return allAvailableDrives;
    }

    public void chooseRide(String userId, String driverId) {
        Driver driver = driverRepository.getDriverById(driverId);
        // if(driver.isAvailable() == false) {
        //     exception;
        // }
        boolean isPresent = false;
        if(allAvailableDrives.size() == 0) {
            System.out.println("No driver is Available");
            return;
        }
        for(int i = 0; i < allAvailableDrives.size(); i++) {
            if(allAvailableDrives.get(i).equals(driver)) isPresent = true;
        }
        //if(!isPresent) exception
        Ride ride = new Ride(userId, driverId, from, to);
        currentRide = ride;
        rideRepository.addRide(ride);
    }

    public Double calculateBill(String userId) {
        //if(currentRide.getUserId() != userId) exception
        String driverId = currentRide.getDriverId();
        Driver driver = driverRepository.getDriverById(driverId);
        return rideRepository.updateEarnings(this.currentRide, driver);
    }


}
