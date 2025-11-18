# Acceptance Criteria for User Stories

## User Story 1: Add Product
**As a** store manager  
**I want to** add new products  
**So that I can** maintain inventory records.

### Acceptance Criteria
- **Given** valid product details (name, quantity, price)  
  **When** the user submits the add request  
  **Then** the system should create a new product with a unique ID.

- Product must not be created if:
  - Name is empty  
  - Quantity is negative  
  - Price is negative

- System should return the created product object.

---

## User Story 2: Update Product
**As a** store manager  
**I want to** update product details  
**So that I can** keep inventory accurate.

### Acceptance Criteria
- **Given** an existing product ID  
  **When** new name, quantity, or price is provided  
  **Then** the system should update the product in the repository.

- If product ID does not exist → return *null* or failure.

---

## User Story 3: Delete Product
**As a** store manager  
**I want to** delete a product  
**So that I can** remove discontinued items.

### Acceptance Criteria
- **Given** a valid product ID  
  **When** delete request is made  
  **Then** the product should be removed from the inventory.

- If ID is invalid → deletion should fail.

---

## User Story 4: View Low Stock Products
**As a** store manager  
**I want to** see products with low stock  
**So that I can** restock them in time.

### Acceptance Criteria
- **Given** a threshold value  
  **When** system checks stock levels  
  **Then** all products with quantity less than threshold should be returned.

- If no products are below threshold → return an empty list.
