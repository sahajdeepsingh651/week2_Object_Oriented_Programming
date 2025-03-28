import java.util.*;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showProduct() {
        System.out.println(name + " - $" + price);
    }
}

class Order {
    static int count = 1;
    int orderId;
    List<Product> productList;
    double totalAmount;

    public Order() {
        this.orderId = count++;
        this.productList = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addProduct(Product p) {
        productList.add(p);
        totalAmount += p.price;
    }

    public void showOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        for (Product p : productList) {
            p.showProduct();
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}

class Customer {
    String name;
    List<Order> orders;

    public Customer(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    public void placeOrder(List<Product> products) {
        Order order = new Order();
        for (Product p : products) {
            order.addProduct(p);
        }
        orders.add(order);
        System.out.println(name + " placed Order ID: " + order.orderId);
    }

    public void showOrders() {
        System.out.println("Customer: " + name);
        for (Order o : orders) {
            o.showOrder();
            System.out.println();
        }
    }
}

class ECommercePlatformDemo {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 850.00);
        Product phone = new Product("Smartphone", 499.00);
        Product headphones = new Product("Headphones", 120.00);

        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        List<Product> order1 = Arrays.asList(laptop, headphones);
        List<Product> order2 = Arrays.asList(phone);

        alice.placeOrder(order1);
        bob.placeOrder(order2);

        System.out.println();
        alice.showOrders();
        bob.showOrders();
    }
}
