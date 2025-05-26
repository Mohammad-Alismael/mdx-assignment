# 🚗 Vehicle Management API


This is a Spring Boot application for managing vehicles. It supports basic CRUD operations with a focus on ensuring unique `plateNumber` values and automatic auditing of creation timestamps.


## Features

- Create, read, update, and delete vehicle records.
- Automatically sets `createdAt` timestamp using JPA Auditing.
- Enforces unique `plateNumber` for each vehicle.
- Uses an in-memory H2 database for testing and development.

---

## 🚀 Getting Started

### 📋 Prerequisites

- Java 17+
- Maven 3.6+

### 📦 Clone & Build

```bash
git clone https://github.com/Mohammad-Alismael/mdx-assignment.git
cd mdx-assignment
mvn clean install
mvn spring-boot:run
```

| Method   | Endpoint         | Description          |
| -------- | ---------------- | -------------------- |
| `POST`   | `/vehicles`      | Create a new vehicle |
| `GET`    | `/vehicles`      | List all vehicles    |
| `GET`    | `/vehicles/{id}` | Get vehicle by ID    |
| `PUT`    | `/vehicles/{id}` | Update a vehicle     |
| `DELETE` | `/vehicles/{id}` | Delete a vehicle     |

📬 Postman Collection
You can test the API using the following Postman collection:

[🔗 Vehicle API Postman Collection](https://universal-star-702907.postman.co/workspace/noise-app~c7d17754-c815-443c-afeb-635926cafbe4/collection/15142683-e40216cd-bd9a-4f9c-8e1c-e22be65275b6?action=share&creator=15142683&active-environment=15142683-607ba2c4-45f5-4014-8bd7-2222ca1c6357)
