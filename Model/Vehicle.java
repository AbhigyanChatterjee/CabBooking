package Model;

public class Vehicle {
    private String vehicleName;
    private String vehiclePlateNumber;
    private Double costPerKilo;

    public Vehicle(String vehicleName, String vehiclePlateNumber) {
        this.vehicleName = vehicleName;
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    
    public Double getCostPerKilo() {
        return costPerKilo;
    }


    public void setCostPerKilo(Double costPerKilo) {
        this.costPerKilo = costPerKilo;
    }


    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }
    

}
