package com.example.inventory.service;
import com.example.inventory.model.Product;


import com.example.inventory.repository.InMemoryProductRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    void testAddProduct() {
        ProductService service = new ProductService(new InMemoryProductRepository());
        Product p = service.addProduct("Pen", 10, 5.0);  // replaced 'var' with 'Product'

        assertNotNull(p);
        assertEquals("Pen", p.getName());
        assertEquals(10, p.getQuantity());
    }
}
