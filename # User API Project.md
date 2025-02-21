# User API Project

## Overview
This project is a Spring Boot-based REST API for managing users. It uses an in-memory H2 database to store user data and exposes various endpoints for interacting with the data.

## Features
- Load user data from an external API (`https://dummyjson.com/users`).
- Expose REST endpoints to:
  - Retrieve all users.
  - Filter users by role.
  - Sort users by age.
  - Search users by ID or SSN.

## Setup
1. Clone or download the repository.
2. Run the application using the following command:
mvn spring-boot:run
3. Access the Swagger documentation at:
http://localhost:8080/swagger-ui/
## Endpoints
- `GET /api/users`: Get all users.
- `GET /api/users/role/{role}`: Get users by role.
- `GET /api/users/age/{sortOrder}`: Get users sorted by age (ascending/descending).
- `GET /api/users/id-or-ssn`: Get user by ID or SSN.
- `POST /api/users/load`: Load users from the external API.