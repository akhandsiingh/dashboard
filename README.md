# Finance Dashboard Backend

## 1. Project Overview

This project is a backend system for managing financial records and generating dashboard insights. It is designed to simulate a real-world finance application where multiple users interact with data based on their assigned roles.

The system focuses on:

* Clean backend architecture
* Role-based access control
* Data processing and aggregation
* REST API design

The backend exposes APIs that can be consumed by any frontend application such as a dashboard UI.

---

## 2. Objectives

The main goals of this project are:

* Manage users with different roles
* Store and process financial records
* Provide summary analytics for dashboards
* Enforce access control based on roles
* Maintain clean and maintainable backend structure

---

## 3. Tech Stack

* Java 17
* Spring Boot 3
* Spring Security (JWT based authentication)
* MongoDB (NoSQL database)
* Maven (build tool)
* Lombok (for reducing boilerplate code)

---

## 4. Project Structure

```
FinanceDashboard/
│
├── controller/
│   Handles all API endpoints
│
├── service/
│   Contains business logic
│
├── repository/
│   Handles database interaction
│
├── model/
│   Contains entity classes and enums
│
├── dto/
│   Handles request and response data transfer
│
├── auth/
│   JWT handling and security configuration
│
├── exception/
│   Global error handling
│
└── application.properties
```

---

## 5. Architecture Explanation

The application follows a layered architecture:

Controller → Service → Repository → Database

* Controller handles incoming requests
* Service processes business logic
* Repository interacts with MongoDB
* Database stores persistent data

This separation ensures clarity, scalability, and maintainability.

---

## 6. User Roles and Permissions

There are three roles in the system:

### ADMIN

* Can create financial records: Yes
* Can view all records: Yes
* Can view dashboard: Yes
* Can view all users: Yes

### ANALYST

* Can create financial records: Yes
* Can view all records: Yes
* Can view dashboard: Yes
* Can view all users: No

### VIEWER

* Can create financial records: No
* Can view all records: No
* Can view dashboard: Yes
* Can view all users: No

---

## 7. Authentication and Security

* Authentication is implemented using JWT (JSON Web Token)
* Users login and receive a token
* Token must be included in all protected API requests
* System is stateless (no session stored on server)

Public APIs:

* Register user
* Login user

Protected APIs:

* All other endpoints

---

## 8. Setup Instructions

### Step 1: Clone the repository

```
git clone <repository-url>
cd finance-dashboard
```

---

### Step 2: Configure MongoDB

Make sure MongoDB is installed and running locally.

Run:

```
mongod
```

---

### Step 3: Configure application properties

Update `application.properties`:

```
spring.data.mongodb.uri=mongodb://localhost:27017/finance_db

jwt.secret=mysecretkeymysecretkeymysecretkey123
jwt.expiration=86400000
```

---

### Step 4: Build and Run

```
mvn clean install
mvn spring-boot:run
```

Application will start on:

```
http://localhost:8080
```

---

## 9. API Endpoints

### 9.1 Authentication APIs

#### Register User

URL:

```
http://localhost:8080/auth/register
```

Method:
POST

Body:

```json
{
  "name": "User",
  "email": "user@test.com",
  "password": "1234"
}
```

---

#### Login User

URL:

```
http://localhost:8080/auth/login
```

Method:
POST

Response:

```json
{
  "token": "JWT_TOKEN"
}
```

---

### 9.2 Financial Records APIs

#### Create Record

URL:

```
http://localhost:8080/records
```

Method:
POST

Access:

* ADMIN: Yes
* ANALYST: Yes
* VIEWER: No

---

#### Get All Records

URL:

```
http://localhost:8080/records
```

Method:
GET

Access:

* ADMIN: Yes
* ANALYST: Yes
* VIEWER: No

---

#### Filter by Type

URL:

```
http://localhost:8080/records/type/{type}
```

Example:

```
http://localhost:8080/records/type/INCOME
```

---

#### Filter by Category

URL:

```
http://localhost:8080/records/category/{category}
```

Example:

```
http://localhost:8080/records/category/Salary
```

---

### 9.3 Dashboard API

#### Get Summary

URL:

```
http://localhost:8080/dashboard
```

Method:
GET

Access:

* ADMIN: Yes
* ANALYST: Yes
* VIEWER: Yes

---

### 9.4 User API

#### Get All Users

URL:

```
http://localhost:8080/users
```

Method:
GET

Access:

* ADMIN: Yes
* ANALYST: No
* VIEWER: No

---

## 10. Request Header Format

All protected APIs require:

```
Authorization: Bearer <JWT_TOKEN>
```

---

## 11. Validation Rules

* Amount must be greater than 0
* Type must be either INCOME or EXPENSE
* Required fields should not be empty

---

## 12. Error Handling

The application uses global exception handling.

Common responses:

* 400 Bad Request → Invalid input
* 403 Forbidden → Unauthorized access
* 500 Internal Server Error → Unexpected issue

---

## 13. Assumptions

* Passwords are stored in plain text
* Roles are manually updated in database
* Single token per login session
* No pagination implemented

---

## 14. Trade-offs

* Simplicity over complexity in authentication
* No password encryption to reduce setup time
* No refresh token implementation
* Focus on core backend logic instead of production-level features

---

## 15. Conclusion

This backend system demonstrates:

* Proper API design
* Role-based access control
* Data modeling with MongoDB
* Clean architecture principles

The project is structured to be readable, maintainable, and aligned with backend development standards expected in real-world systems.

---
