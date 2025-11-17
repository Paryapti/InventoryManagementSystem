package com.example.inventory.repository;


import com.example.inventory.model.Product;
import java.util.ArrayList;
import java.util.List;

public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void update(Product updatedProduct) {
        Product p = findById(updatedProduct.getId());
        if (p != null) {
            p.setName(updatedProduct.getName());
            p.setQuantity(updatedProduct.getQuantity());
            p.setPrice(updatedProduct.getPrice());
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
