# Project Description: Hotel Management System
The Hotel Management System is a Spring Boot microservices-based application designed to manage hotel data and services. The system is modular, scalable, and follows best practices for microservice architecture, ensuring high performance and maintainability.

## Current Scope: Hotel Service
The Hotel Service is one of the core microservices in the Hotel Management System. It provides a set of RESTful APIs to perform CRUD (Create, Read, Update, Delete) operations on hotel data. Below are the key APIs:

Add Hotel (POST /add-hotel):
Allows clients to add a new hotel to the system. The hotel details, including name, location, and about, are provided as part of the request payload.

Update Hotel (PUT /{hotelId}/update):
Facilitates full updates of an existing hotel. Clients must provide the hotelId and all required details in the request.

Get All Hotels (GET /hotellist):
Retrieves a list of all hotels in the system.

Get Hotel by ID (GET /{hotelId}):
Fetches details of a specific hotel by its unique hotelId.

Partially Update Hotel (PATCH /{hotelId}/update):
Supports partial updates for specific fields of an existing hotel. This API ensures that only the provided fields are updated while keeping the rest of the data intact.

## Entity Class
The Hotel entity represents the structure of the hotel data stored in the system. Its attributes include:

Id: Unique identifier for each hotel.
name: Name of the hotel.
location: Location of the hotel.
about: Additional details about the hotel.

## Key Features
Ehcache Integration:
The application uses Ehcache to optimize performance by caching frequently accessed data, reducing the load on the database and improving response times.

## Service Discovery with Eureka:
The microservice is registered with a Eureka Server, enabling dynamic service discovery and load balancing. This ensures that the system remains resilient and scalable in distributed environments.

## Technology Stack
Backend: Spring Boot, Database: MySql, Caching: Ehcache, Service Discovery: Eureka Server, Tools: Postman for API testing
