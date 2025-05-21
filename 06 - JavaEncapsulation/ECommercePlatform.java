// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getter and Setter methods (Encapsulation)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method to calculate discount
    public abstract double calculateDiscount();

    // Abstract method to calculate tax (for Taxable products)
    public abstract double calculateTax();

    // Method to display product details (to be implemented in subclasses if needed)
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: $" + price);
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics subclass
class Electronics extends Product implements Taxable {
    private double discountRate;

    // Constructor
    public Electronics(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;  // Discount for electronics
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.10;  // 10% tax for electronics
    }

    @Override
    public String getTaxDetails() {
        return "Electronics tax rate: 10%";
    }

    // Override displayDetails() to show Electronics specific details
    @Override
    public void displayDetails() {
        super.displayDetails();  // Call the base class method
        System.out.println("Category: Electronics");
    }
}

// Clothing subclass
class Clothing extends Product implements Taxable {
    private double discountRate;

    // Constructor
    public Clothing(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;  // Discount for clothing
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;  // 5% tax for clothing
    }

    @Override
    public String getTaxDetails() {
        return "Clothing tax rate: 5%";
    }

    // Override displayDetails() to show Clothing specific details
    @Override
    public void displayDetails() {
        super.displayDetails();  // Call the base class method
        System.out.println("Category: Clothing");
    }
}

// Groceries subclass (No Tax, but needs the interface)
class Groceries extends Product implements Taxable {
    private double discountRate;

    // Constructor
    public Groceries(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;  // Discount for groceries
    }

    @Override
    public double calculateTax() {
        return 0;  // No tax on groceries
    }

    @Override
    public String getTaxDetails() {
        return "Groceries are tax-free.";
    }

    // Override displayDetails() to show Groceries specific details
    @Override
    public void displayDetails() {
        super.displayDetails();  // Call the base class method
        System.out.println("Category: Groceries");
    }
}

// Main class to test the e-commerce platform
public class ECommercePlatform {
    public static void main(String[] args) {
        // Create instances of different product categories
        Product p1 = new Electronics(101, "Laptop", 1000.00, 0.10); // 10% discount
        Product p2 = new Clothing(102, "T-shirt", 20.00, 0.15); // 15% discount
        Product p3 = new Groceries(103, "Apples", 5.00, 0.05); // 5% discount

        // Display product details and calculate final prices
        Product[] products = { p1, p2, p3 };

        for (Product product : products) {
            product.displayDetails();  // Display product details
            System.out.println("Discount: $" + product.calculateDiscount());
            System.out.println("Tax: $" + product.calculateTax());
            System.out.println("Final Price: $" + (product.getPrice() + product.calculateTax() - product.calculateDiscount()));
            System.out.println();
        }
    }
}
