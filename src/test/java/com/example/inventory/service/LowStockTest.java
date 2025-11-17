package com.example.inventory.service;


import com.example.inventory.repository.InMemoryProductRepository;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LowStockTest {

    @Test
    void testLowStockFilter() {
        ProductService service = new ProductService(new InMemoryProductRepository());
        service.addProduct("A", 5, 10);
        service.addProduct("B", 50, 100);

        List<?> low = service.getLowStockProducts(10);

        assertEquals(1, low.size());
    }
}
