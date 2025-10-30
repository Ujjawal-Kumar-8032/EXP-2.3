import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    int id;
    String name;
    double price;
    String category;

    Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

public class StreamProducts {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 80000, "Electronics"),
            new Product(2, "Smartphone", 40000, "Electronics"),
            new Product(3, "Office Chair", 12000, "Furniture"),
            new Product(4, "Desk", 8000, "Furniture"),
            new Product(5, "Headphones", 3000, "Electronics")
        );

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category,
                    Collectors.maxBy(Comparator.comparingDouble(p -> p.price))));

        mostExpensiveByCategory.forEach((category, product) ->
            System.out.println(category + " → Most Expensive: " + product.get().name + " (₹" + (int)product.get().price + ")")
        );

        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(p -> p.price));

        System.out.println("Average Price of All Products: ₹" + (int)averagePrice);
    }
}
