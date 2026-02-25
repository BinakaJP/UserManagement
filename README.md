# User Management API — Spring Boot

A RESTful API for managing users, built with **Spring Boot** and **MongoDB**. Supports full CRUD operations plus search and age-range filtering.

## Tech Stack

- Java / Spring Boot 4.0.2
- MongoDB
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 17+
- MongoDB running on `localhost:27017`
- Maven (or use the included `./mvnw` wrapper)

### Run the Application

```bash
./mvnw spring-boot:run
```

The server starts on **http://localhost:8080**

## API Endpoints

Base URL: `/api/users`

| Method | Endpoint              | Description                        |
|--------|-----------------------|------------------------------------|
| GET    | `/api/users`          | Get all users                      |
| GET    | `/api/users/{id}`     | Get a user by ID                   |
| POST   | `/api/users`          | Create a new user                  |
| PUT    | `/api/users/{id}`     | Update an existing user            |
| DELETE | `/api/users/{id}`     | Delete a user                      |
| GET    | `/api/users/search?name=` | Search users by name (case-insensitive) |
| GET    | `/api/users/age-range?min=&max=` | Get users within an age range |

## User Model

```json
{
  "id": "string",
  "name": "string",
  "email": "string",
  "age": 0
}
```

## Example Requests

**Create a user**
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name": "Alice", "email": "alice@example.com", "age": 28}'
```

**Search by name**
```bash
curl http://localhost:8080/api/users/search?name=alice
```

**Filter by age range**
```bash
curl http://localhost:8080/api/users/age-range?min=20&max=30
```

## Related Project

- [User Management API — Node.js](https://github.com/BinakaJP/UserManagementNode) — same functionality implemented with Node.js/Express
