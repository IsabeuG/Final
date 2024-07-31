# ReadMe

## Overview

This project is a Spring Boot application that includes basic user management and file handling functionality. The application allows users to register, login, and manage their files. The backend provides RESTful APIs for user and file operations, secured with Spring Security.

## Table of Contents
1. [Project Structure](#project-structure)
2. [Installation](#installation)
3. [Usage](#usage)
4. [Testing](#testing)
5. [Endpoints](#endpoints)
6. [Security](#security)

## Project Structure
src/main/java/org/example/

|-- DemoApplication.java

|-- config/

|   |-- WebSecurityConfig.java

|-- controller/

|   |-- FileController.java

|   |-- UserController.java

|-- entity/

|   |-- File.java

|   |-- User.java

|-- repository/

|   |-- FileRepository.java

|   |-- UserRepository.java

|-- service/

|   |-- FileService.java

|   |-- UserService.java

src/test/java/org/example/demo/test/

|-- UserServiceTest.java


## Installation

1. Clone the repository:
  
   git clone [https://github.com/your-repo/demo-application.git](https://github.com/IsabeuG/Final.git)
   cd demo-application
   
2. Build the project:
  
   ./mvnw clean install
   
3. Run the application:
  
   ./mvnw spring-boot:run
   
## Usage

### Running the Application
- The application will start on http://localhost:8080.

### Register a New User
- Send a POST request to /api/users/register with JSON payload:
 
  {
    "username": "your_username",
    "password": "your_password"
  }
  
### Login
- Access the login page at /login or authenticate via an HTTP client.

### Managing Files
- After logging in, you can upload, list, and delete files using the provided endpoints.

## Testing

- The project includes unit tests for the UserService class.
- To run the tests, use:
 
  ./mvnw test
  
## Endpoints

### User Endpoints
- Register a User
  - POST /api/users/register
  - Payload: { "username": "your_username", "password": "your_password" }
  
### File Endpoints
- List Files
  - GET /api/files
- Upload File
  - POST /api/files
  - Form Data: file: [file]
- Delete File
  - DELETE /api/files/{id}

## Security

### Web Security Configuration
- Configuration Class: WebSecurityConfig
- Password Encoding: Uses BCryptPasswordEncoder
- Public Endpoint: /api/users/register
- Protected Endpoints: All other endpoints require authentication.

## Code Details

### DemoApplication.java
- Main class to run the Spring Boot application.

### WebSecurityConfig.java
- Configures security settings, including authentication and authorization rules.

### UserController.java & FileController.java
- REST controllers for user registration and file management.

### UserService.java & FileService.java
- Service classes that contain business logic for user and file operations.

### UserRepository.java & FileRepository.java
- Repository interfaces for database operations.

### User.java & File.java
- Entity classes representing the database schema for users and files.

### UserServiceTest.java & FileControllerTest.java & FileServiceTest.java & UserControllerTest.java
- Unit tests for the UserService, FileController, FileService, UserController classes, verifying user loading and saving logic.
