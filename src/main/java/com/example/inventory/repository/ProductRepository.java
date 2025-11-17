package com.example.inventory.repository;


import com.example.inventory.model.Product;
import java.util.List;

public interface ProductRepository {
    void add(Product product);
    Product findById(int id);
    List<Product> findAll();
    void update(Product product);
    void delete(int id);
}
