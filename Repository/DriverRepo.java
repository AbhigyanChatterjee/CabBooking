package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Model.Driver;
import Model.Location;
import Model.User;

public class DriverRepo {
    private static DriverRepo driverRepo = new DriverRepo();
    private Map<String, Driver> allDrivers;
    

    private DriverRepo() {
        allDrivers = new HashMap<String, Driver>();
    }

    public static DriverRepo makeDriverRepo(){
        return driverRepo;
    }

    public void addDriver(Driver driver) {
        allDrivers.put(driver.getDriverId(), driver);
    }

    public Driver getDriverById(String driverId) {
        if(!allDrivers.containsKey(driverId)) {
            System.out.println("Driver isn't present in allDrivers");
            return null;
        }
        return allDrivers.get(driverId);
    }

    public void getAllDriversEarnings() {
        for(Map.Entry mapElement : allDrivers.entrySet()) {
            String key = (String)mapElement.getKey();
            Driver driver = allDrivers.get(key);
            System.out.println(driver.getName() + " earned " + driver.getEarnings());
        }
    }
    public List<Driver> getAllAvailableDrivers(Location userLocation, Double distance) {
        List<Driver> availableDrivers = new ArrayList<Driver>();
        Driver driver;
        Double dist;
        for (Map.Entry mapElement : allDrivers.entrySet()) {
            String key = (String)mapElement.getKey();
            driver = allDrivers.get(key);
            Location currentDriverLocation = driver.getCurrentLocation();
            dist = currentDriverLocation.distance(userLocation);

            if(dist <= distance && driver.isAvailable()) {
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }

    
    
}
