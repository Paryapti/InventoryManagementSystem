package com.example.inventory.functional;

import com.example.inventory.model.Product;
import com.example.inventory.service.ProductService;
import com.example.inventory.repository.InMemoryProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFunctionalTest {

    private ProductService service;

    @BeforeEach
    void setup() {
        service = new ProductService(new InMemoryProductRepository());
    }

    @Test
    void testAddUpdateDeleteProduct() {
        // Add product
        Product p = service.addProduct("Pen", 10, 5.0);
        assertNotNull(p);
        assertEquals("Pen", p.getName());

        // Update product (void return)
        service.updateProduct(p.getId(), "Pencil", 15, 3.0);

        // Get updated product from list
        Product updated = service.getAll()
                .stream()
                .filter(prod -> prod.getId() == p.getId())
                .findFirst()
                .orElse(null);

        assertNotNull(updated);
        assertEquals("Pencil", updated.getName());
        assertEquals(15, updated.getQuantity());

        // Delete product (void return)
        service.deleteProduct(p.getId());

        // Confirm deletion
        Product deleted = service.getAll()
                .stream()
                .filter(prod -> prod.getId() == p.getId())
                .findFirst()
                .orElse(null);

        assertNull(deleted);
    }

    @Test
    void testLowStockProducts() {
        service.addProduct("Notebook", 2, 10.0);
        service.addProduct("Marker", 6, 2.5);
    
        java.util.List<Product> lowStock = service.getLowStockProducts(5);
        assertEquals(1, lowStock.size());
        assertEquals("Notebook", lowStock.get(0).getName());
    }
    
}
