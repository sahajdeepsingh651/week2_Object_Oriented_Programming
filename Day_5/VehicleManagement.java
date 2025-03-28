// Superclass Vehicle
class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface Refuelable
interface Refuelable {
    void refuel();
}

// ElectricVehicle subclass: inherits from Vehicle
class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println("Charging the electric vehicle...");
    }
}

// PetrolVehicle subclass: inherits from Vehicle and implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacity;

    PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the petrol vehicle...");
    }
}

// Main class to demonstrate the hybrid inheritance
public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model S", 100);
        PetrolVehicle pv = new PetrolVehicle(180, "Ford Mustang", 60);

        System.out.println("Electric Vehicle Info:");
        ev.displayInfo();
        ev.charge();

        System.out.println();

        System.out.println("Petrol Vehicle Info:");
        pv.displayInfo();
        pv.refuel();
    }
}
