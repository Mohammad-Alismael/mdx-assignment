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
