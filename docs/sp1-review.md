# Sprint 1 Review

## Sprint Goal
Set up the project structure, basic classes, and repository implementation for the Inventory Management System.

---

## Completed Work
- Created Java project using Maven.
- Added main package structure:
  - model/Product.java
  - repository/ProductRepository + InMemoryProductRepository
  - service/ProductService
- Implemented core operations:
  - Add Product
  - Update Product
  - Delete Product
  - Get All Products
- Wrote **unit tests** for ProductService.

---

## Demo Summary
- Running the application using `mvn exec:java` shows core features working.
- Unit tests executed successfully with `mvn test`.

---

## What Went Well
- Repository layer designed using interface → easy to extend.
- Unit testing helped catch early issues.
- Good collaboration and clear requirements.

---

## What Could Be Improved
- Need better validation for invalid inputs.
- Improve documentation for service methods.

---

## Carryover to Next Sprint
- Implement functional tests simulating real scenarios.
- Add low-stock functionality.
- Prepare acceptance criteria.
