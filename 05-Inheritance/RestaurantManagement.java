// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface
interface Worker {
    void performDuties();
}

// Chef class: inherits from Person and implements Worker
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void performDuties() {
        System.out.println("Duties: Cooking dishes. Specialty: " + specialty);
    }
}

// Waiter class: inherits from Person and implements Worker
class Waiter extends Person implements Worker {
    int tableCount;

    Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    public void performDuties() {
        System.out.println("Duties: Serving customers at " + tableCount + " tables.");
    }
}

// Main class
public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Rahul", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Meena", 102, 5);

        System.out.println("Chef Info:");
        chef.displayInfo();
        chef.performDuties();

        System.out.println();

        System.out.println("Waiter Info:");
        waiter.displayInfo();
        waiter.performDuties();
    }
}
