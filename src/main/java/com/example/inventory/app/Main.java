package com.example.inventory;

import com.example.inventory.service.ProductService;
import com.example.inventory.repository.InMemoryProductRepository;
import com.example.inventory.model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService(new InMemoryProductRepository());

        while (true) {
            System.out.println("\n=== Inventory Management ===");
            System.out.println("1. Add Product");
            System.out.println("2. List Products");
            System.out.println("3. Check Low Stock");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // consume newline

                    Product p = service.addProduct(name, qty, price);
                    System.out.println("Added: " + p.getName() + " | Qty: " + p.getQuantity() + " | Price: " + p.getPrice());
                    break;

                    case 2:
                    List<Product> products = service.getAll(); // <-- changed here
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        System.out.println("Products:");
                        for (Product prod : products) {
                            System.out.println(prod.getName() + " | Qty: " + prod.getQuantity() + " | Price: " + prod.getPrice());
                        }
                    }
                    break;
                

                case 3:
                    System.out.print("Enter low stock threshold: ");
                    int threshold = sc.nextInt();
                    sc.nextLine(); // consume newline
                    List<Product> lowStock = service.getLowStockProducts(threshold);
                    if (lowStock.isEmpty()) {
                        System.out.println("No low stock products.");
                    } else {
                        System.out.println("Low Stock Products:");
                        for (Product prod : lowStock) {
                            System.out.println(prod.getName() + " | Qty: " + prod.getQuantity());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
