# Bookstore Microservices Application

## Overview
This project is a microservices-based bookstore application that demonstrates a modern cloud-native architecture. It allows users to browse books, place orders, and process payments through a set of interconnected services.

## Architecture
The application follows a microservices architecture pattern with the following components:
- **Service Discovery** (Eureka): Enables services to find and communicate with each other
- **API Gateway**: Single entry point for all client requests, routing to appropriate services
- **Microservices**: Independent services for specific business domains
- **Database**: PostgreSQL for data persistence

## Microservices
The application consists of the following microservices:

### Eureka Service
Service discovery server that allows microservices to find and communicate with each other without hardcoding hostname and port.

### Gateway Service
API Gateway that provides a single entry point for all client requests. Routes requests to appropriate microservices.

### User Service
Manages user accounts and authentication.
- Endpoints:
  - POST `/users`: Create a new user
  - GET `/users/{id}`: Get user by ID

### Book Inventory Service
Manages the book catalog and inventory.
- Endpoints:
  - POST `/books`: Add a new book
  - GET `/books/{id}`: Get book by ID

### Order Service
Handles order creation and management.
- Endpoints:
  - POST `/orders`: Create a new order
  - GET `/orders/{id}`: Get order by ID
  - GET `/orders`: Get all orders
  - PUT `/orders/{id}`: Update an order

### Payment Service
Processes payments for orders.
- Endpoints:
  - POST `/payments`: Process a payment
  - GET `/payments/{id}`: Get payment by ID

## Technologies Used
- **Spring Boot**: Framework for creating stand-alone, production-grade Spring applications
- **Spring Cloud**: Tools for building common patterns in distributed systems
- **Netflix Eureka**: Service discovery server and client
- **Spring Cloud Gateway**: API Gateway
- **Spring Data JPA**: Data access layer
- **PostgreSQL**: Relational database
- **Docker**: Containerization
- **Docker Compose**: Multi-container Docker applications

## How to Run

### Prerequisites
- Docker and Docker Compose
- Java 17 or higher
- Maven

### Steps
1. Clone the repository
   ```
   git clone https://github.com/yourusername/bookstore.git
   cd bookstore
   ```

2. Build the project
   ```
   mvn clean package -DskipTests
   ```

3. Start the services using Docker Compose
   ```
   docker-compose up -d
   ```

4. The services will be available at:
   - Eureka Dashboard: http://localhost:8761
   - API Gateway: http://localhost:8080
   - User Service: http://localhost:8081
   - Book Inventory Service: http://localhost:8082
   - Order Service: http://localhost:8083
   - Payment Service: http://localhost:8084

## Development

### Database
The application uses PostgreSQL as its database. The database is automatically created when running with Docker Compose.

### Service Dependencies
- **User Service**: Depends on Eureka Service and PostgreSQL
- **Book Inventory Service**: Depends on Eureka Service and PostgreSQL
- **Order Service**: Depends on Eureka Service, Book Inventory Service, and PostgreSQL
- **Payment Service**: Depends on Eureka Service and PostgreSQL

## API Usage Examples

### Create a User
```
POST /users
{
  "username": "john_doe",
  "password": "secure_password"
}
```

### Add a Book
```
POST /books
{
  "title": "Spring Microservices in Action",
  "author": "John Carnell",
  "isbn": "9781617293986",
  "price": 49.99,
  "stock": 100
}
```

### Create an Order
```
POST /orders
{
  "customerId": 1,
  "bookId": 1,
  "orderDate": "2023-06-15T10:30:00",
  "totalAmount": 49.99,
  "status": "PENDING"
}
```

### Process a Payment
```
POST /payments
{
  "orderId": 1,
  "amount": 49.99,
  "paymentMethod": "CREDIT_CARD",
  "status": "COMPLETED"
}
```
