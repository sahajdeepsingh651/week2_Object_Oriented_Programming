// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter and Setter methods (Encapsulation)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
    }

    // Abstract method to calculate total price (to be overridden in subclasses)
    public abstract double calculateTotalPrice();
}

// Interface Discountable
interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

// VegItem subclass (for vegetarian items)
class VegItem extends FoodItem implements Discountable {
    private double discount;

    // Constructor
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // No extra charges for Veg items
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        discount = (getPrice() * discountPercentage) / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount: " + discount;
    }
}

// NonVegItem subclass (for non-vegetarian items)
class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge = 2.5; // Extra charge for non-veg items
    private double discount;

    // Constructor
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double basePrice = getPrice() * getQuantity();
        return basePrice + additionalCharge * getQuantity(); // Additional charge for non-veg items
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        discount = (getPrice() * discountPercentage) / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount: " + discount;
    }
}

// Main class to demonstrate the system
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        // Create instances of food items
        FoodItem vegItem = new VegItem("Veg Pizza", 12.99, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Burger", 8.99, 3);

        // Apply discounts
        if (vegItem instanceof Discountable) {
            Discountable discountableVeg = (Discountable) vegItem;
            discountableVeg.applyDiscount(10); // Apply 10% discount
        }

        if (nonVegItem instanceof Discountable) {
            Discountable discountableNonVeg = (Discountable) nonVegItem;
            discountableNonVeg.applyDiscount(15); // Apply 15% discount
        }

        // Process food items and display their details
        FoodItem[] order = {vegItem, nonVegItem};

        for (FoodItem item : order) {
            System.out.println("\nItem Details:");
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                System.out.println(discountableItem.getDiscountDetails());
            }
        }
    }
}
