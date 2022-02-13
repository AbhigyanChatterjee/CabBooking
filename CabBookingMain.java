import java.util.List;

import Model.Driver;
import Model.GenderEnum;
import Model.Location;
import Model.User;
import Model.Vehicle;
import Repository.DriverRepo;
import Repository.RideRepo;
import Repository.UserRepo;
import Service.DriverService;
import Service.UserService;

public class CabBookingMain {
    public static void main(String[] args) {
        UserRepo userRepo = UserRepo.makeUserRepo();
        RideRepo rideRepo = RideRepo.makeRideRepo();
        DriverRepo driverRepo = DriverRepo.makeDriverRepo();

        DriverService driverService = new DriverService(driverRepo, rideRepo);
        UserService userService = new UserService(userRepo, rideRepo, driverRepo);
        User user1 = new User("Abhigyan", GenderEnum.Male, 22);
        String user1Id = user1.getUserId();
        userService.addUser(user1);
        String number = "9860140958";
        userService.updateUser(user1Id, number);
        Location location = new Location(10, 12);
        userService.updateUserLocation(user1Id, location);
        Vehicle vehicle1 = new Vehicle("Swift", "AP-33-BA-9180");
        Double vehicle1CostPerKilo = 10.0;
        vehicle1.setCostPerKilo(vehicle1CostPerKilo);
        Location driverLocation = new Location(12, 13);
        Driver driver1 = new Driver("Abhishek", GenderEnum.Male, 22, vehicle1, driverLocation);
        String driver1Id = driver1.getDriverId();
        driverService.addDriver(driver1);
        Location newDriver1Location = new Location(13, 12);
        driverService.updateDriverLocation(driver1Id, newDriver1Location);
        Location from = new Location(10, 12);
        Location to = new Location(18, 15);
        List<Driver> drivers1 = userService.findRide(user1Id, from, to);
        for(int i = 0; i < drivers1.size(); i++) {
            System.out.println(drivers1.get(i).toString());
        }
        userService.chooseRide(user1Id, driver1Id);
        Double user1Bill1 = userService.calculateBill(user1Id);
        System.out.println(user1Bill1);
        driverService.findTotalEarnings();
        // boolean driverAvailable = false;
        // driverService.changeDriverStatus(driver1Id, driverAvailable);
        
    }
}
