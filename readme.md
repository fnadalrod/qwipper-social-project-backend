# Users Service

This repository contains the `users-service`, which is a foundational part of a microservices-based system for managing user data. This service is the first bounded context of a larger project aiming to create a Twitter-like application. At this stage, only the **Users** bounded context is implemented.

The service is built using **Spring Boot**, **MongoDB**, and follows best practices like **Domain-Driven Design (DDD)**, **Hexagonal Architecture**, and **CQRS**.

## Project Architecture

The project is structured to ensure scalability and maintainability by using modern software design principles:

### Domain-Driven Design (DDD)
- **DDD** is used to focus on the business domain, encapsulating the logic in the **domain layer**. This ensures that the application is aligned with business needs and reduces complexity by clearly defining **Aggregates**, **Entities**, **Value Objects**, **Domain Services**, **Repositories**, and **Factories**.

### Hexagonal Architecture (Ports and Adapters)
- The service follows **Hexagonal Architecture** (also known as **Ports and Adapters**). In this structure, the core business logic interacts with external systems through well-defined **Ports** (interfaces) and **Adapters** (implementations), ensuring that the core logic remains independent of the external technologies and infrastructure.

### CQRS (Command Query Responsibility Segregation)
- The system uses **CQRS**, where **commands** are responsible for modifying the system's state (e.g., creating or updating users), and **queries** are used solely for reading data (e.g., retrieving user information).
  
This allows the system to scale better and handle more complex business logic more efficiently.

## Services

### `users-service`
- **Purpose**: This service is responsible for managing user-related operations, such as creating, updating, and retrieving user information.
- **Dependencies**: MongoDB for data storage.
- **Architecture**: The service is designed using **DDD**, **Hexagonal Architecture**, and **CQRS** principles.
- **API**: Exposes a REST API on port `8085` for interaction with other services and clients.
- **Database**: MongoDB for storing user-related data.
- **Health Check**: The service includes a health check endpoint at `/actuator/health` to ensure the service is running correctly.

### MongoDB Service
- **Purpose**: Provides data storage for the `users-service` using MongoDB.
- **Port**: The MongoDB service runs on port `27018`.

## Running the Application

### Prerequisites
Ensure that the following tools are installed on your local machine:
- Docker
- Docker Compose

### Steps to Run
1. Clone this repository to your local machine.
2. Make sure the necessary environment variables (`MONGO_INITDB_ROOT_USERNAME`, `MONGO_INITDB_ROOT_PASSWORD`, etc.) are set.
3. From the root of the project, run the following command to build and start the services:

   ```bash
   docker-compose up --build
