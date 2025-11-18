# Agile Testing Quadrants – Documentation

Agile Testing Quadrants categorize types of tests based on their purpose and value.

---

## **Quadrant Q1 – Technology-Facing Tests (Unit Tests)**
- Tests written by developers.
- Support the code and design.
- Automated.
### Examples in this project:
- `ProductServiceTest` → Validates add, update, delete logic.

---

## **Quadrant Q2 – Business-Facing Tests (Functional Tests)**
- Verify that the system meets business needs.
- Automated or manual.
### Examples in this project:
- `ProductFunctionalTest` → Verifies complete product workflow:
  - Add  
  - Update  
  - Delete  
  - Low stock filtering

---

## **Quadrant Q3 – Business-Facing Tests (Exploratory/Manual)**
- Evaluate user experience.
- Conducted manually by testers or product owner.
### Examples for this project:
- Manual testing of console-based user input.
- Checking invalid inputs (Negative quantity / price).
- Checking how system behaves when repository is empty.

---

## **Quadrant Q4 – Technology-Facing Tests (Non-Functional)**
- Evaluate performance, reliability, and scalability.
### Possible tests for future:
- Load test for large inventory.
- Performance test for repeated add/update operations.
- Memory usage evaluation.

---

# Summary Table

| Quadrant | Purpose | Type | Example |
|----------|---------|------|---------|
| Q1 | Support developer | Unit | ProductServiceTest |
| Q2 | Support business | Functional | ProductFunctionalTest |
| Q3 | Critique product | Exploratory | Manual invalid-input testing |
| Q4 | Critique product | Non-functional | Performance load tests |
