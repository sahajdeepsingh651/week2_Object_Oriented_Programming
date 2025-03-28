// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getter and Setter methods (Encapsulation)
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    // Concrete method to display vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate Per Kilometer: " + ratePerKm);
    }

    // Abstract method to calculate fare based on distance
    public abstract double calculateFare(double distance);
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Subclass Car
class Car extends Vehicle implements GPS {
    private String location;

    // Constructor
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Subclass Bike
class Bike extends Vehicle implements GPS {
    private String location;

    // Constructor
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Subclass Auto
class Auto extends Vehicle implements GPS {
    private String location;

    // Constructor
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Main class to demonstrate the system
public class RideHailingApplication {
    public static void main(String[] args) {
        // Create vehicle instances
        Vehicle car = new Car("V123", "Alice", 10.0);  // $10 per km
        Vehicle bike = new Bike("V124", "Bob", 5.0);   // $5 per km
        Vehicle auto = new Auto("V125", "Charlie", 7.0); // $7 per km

        // Update vehicle locations
        if (car instanceof GPS) {
            GPS gpsCar = (GPS) car;
            gpsCar.updateLocation("Downtown");
        }

        if (bike instanceof GPS) {
            GPS gpsBike = (GPS) bike;
            gpsBike.updateLocation("Uptown");
        }

        if (auto instanceof GPS) {
            GPS gpsAuto = (GPS) auto;
            gpsAuto.updateLocation("Suburb");
        }

        // Process vehicles and calculate fares for a given distance (e.g., 10 km)
        Vehicle[] vehicles = {car, bike, auto};
        double distance = 10.0; // Distance in kilometers

        for (Vehicle vehicle : vehicles) {
            System.out.println("\nVehicle Details:");
            vehicle.getVehicleDetails();
            System.out.println("Current Location: " + ((GPS) vehicle).getCurrentLocation());
            System.out.println("Fare for " + distance + " km: " + vehicle.calculateFare(distance));
        }
    }
}
