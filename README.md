# 🛒📦 Sales API - Java Spring Boot

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

This REST API allows users to manage a simple sales system with products, clients, and sales. It supports operations like registering and updating stock, creating clients, and processing sales with multiple items.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

---

## Features

- ✅ Register and list products
- ✅ Update product stock quantity via endpoint
- ✅ Register and list clients
- ✅ Register sales with multiple items
- ✅ See all sales with client and items included
- ✅ Prevent duplicate product names
- ✅ PostgreSQL database persistence

---

## ⚙️ How to Run

### 🔧 Database Setup

Before running the project, make sure you have PostgreSQL installed and running. Then:

1. Create a database named `sales_api`
2. Update your `application.properties` or `application.yml` file with your PostgreSQL credentials:
   ```properties
   spring.application.name=salesapi
   spring.datasource.url=jdbc:postgresql://localhost:5432/sales_api
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   server.port=8080
   ```

### ▶️ Start the Application

```bash
git clone https://github.com/bruno2leite/sales-api.git
cd sales-api
mvn spring-boot:run
```

API available at:  
📍 `http://localhost:8080`

---

## 📮 API Endpoints

### 🔹 Products

- `GET /products`  
  Lists all products, ordered by ID.

- `POST /products`  
  Registers a new product.
  **Request Body:**
  ```json
  {
  "name": "Apple",
  "price": 1,
  "stock": 10
  }
  ```

- `PUT /products/restock`  
  Updates the stock quantity of a product.  
  **Request Body:**
  ```json
  {
    "id": 1,
    "quantity": 10
  }
  ```

---

### 🔹 Customers

- `GET /customers`  
  Lists all registered customers.

- `POST /customers`  
  Creates a new customer.
  **Request Body:**
  ```json
  {
  "name": "João Silva",
  "cpf": "32345698900"
  }

---

### 🔹 Sales

- `GET /sales`  
  Lists all sales including client and item information.

  - `GET /sales/customers/{id}`  
  List all sales by customer ID.
  
- `POST /sales`  
  Creates a new sale linked to a client with a list of items.  
  **Request Body:**
  ```json
  {
    "clientId": 1,
    "items": [
      {
        "productId": 1,
        "quantity": 2
      },
      {
        "productId": 2,
        "quantity": 1
      }
    ]
  }
  ```


## 👨‍💻 Author

Developed by **Bruno Leite**  
🔗 [www.linkedin.com/in/brunoprestesleite](https://www.linkedin.com/in/brunoprestesleite)
---
