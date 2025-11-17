package com.example.inventory.service;

import com.example.inventory.model.Product;
import com.example.inventory.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository repo;
    private int autoId = 1;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(String name, int qty, double price) {
        Product p = new Product(autoId++, name, qty, price);
        repo.add(p);
        return p;
    }

    public void updateProduct(int id, String name, int qty, double price) {
        Product p = new Product(id, name, qty, price);
        repo.update(p);
    }

    public void deleteProduct(int id) {
        repo.delete(id);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public List<Product> getLowStockProducts(int threshold) {
        return repo.findAll()
                .stream()
                .filter(p -> p.getQuantity() < threshold)
                .collect(Collectors.toList());
    }
}
