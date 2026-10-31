# LearningRESTAPIs

A Student Management REST API built using **Java, Spring Boot, Spring Data JPA, and PostgreSQL**. This project demonstrates RESTful API development with a layered architecture, DTOs, input validation, and CRUD operations.

## Tech Stack

- **Language:** Java
- **Backend:** Spring Boot
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA / Hibernate
- **Build Tool:** Maven
- **DTO Mapping:** ModelMapper
- **Validation:** Jakarta Bean Validation
- **Libraries:** Lombok

## Project Architecture

The application follows a layered architecture:

```text
Controller
    |
    v
Service
    |
    v
Repository
    |
    v
PostgreSQL Database
```

### Layers

- **Controller:** Handles incoming HTTP requests and sends appropriate responses.
- **Service:** Implements student-related business logic.
- **Repository:** Performs database operations using Spring Data JPA.
- **Entity:** Represents the Student database entity.
- **DTO:** Transfers data between the client and application.
- **MapperConfig:** Configures ModelMapper for entity and DTO mapping.

## Features

- Retrieve all students
- Retrieve a student by ID
- Add a new student
- Update complete student details
- Partially update student details
- Delete a student by ID
- Validate student name and email
- Handle unsupported fields in partial updates

## REST API Endpoints

Base URL:

```text
http://localhost:8080/api/students
```

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students` | Create a student |
| PUT | `/students/{id}` | Update student details |
| PATCH | `/students/{id}` | Partially update student |
| DELETE | `/students/{id}` | Delete a student |

### 1. Get All Students

**GET** `/api/students`

Retrieves all student records.

### 2. Get Student By ID

**GET** `/api/students/{id}`

Retrieves a student using their ID.

### 3. Create Student

**POST** `/api/students`

Request Body:

```json
{
  "name": "Rahul Sharma",
  "email": "rahul@example.com"
}
```

Validation:
- Name is required and must contain between 3 and 30 characters.
- Email is required and must have a valid email format.

Response:

```json
{
  "id": 1,
  "name": "Rahul Sharma",
  "email": "rahul@example.com"
}
```

HTTP Status: `201 Created`

### 4. Update Student

**PUT** `/api/students/{id}`

Updates the student's name and email.

Request Body:

```json
{
  "name": "Rahul Verma",
  "email": "rahul.verma@example.com"
}
```

HTTP Status: `200 OK`

### 5. Partially Update Student

**PATCH** `/api/students/{id}`

Updates selected student fields. Currently supported fields are `name` and `email`.

Request Body:

```json
{
  "name": "Rahul Verma"
}
```

HTTP Status: `200 OK`

### 6. Delete Student

**DELETE** `/api/students/{id}`

Deletes a student using their ID.

HTTP Status: `204 No Content`

## Database Configuration

The application uses PostgreSQL.

Create a database named:

```sql
CREATE DATABASE studentdb;
```

Configure the database connection in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.servlet.context-path=/api
```

Replace the username and password with your local PostgreSQL credentials. Do not commit actual database passwords or other secrets to GitHub.

## How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/rutvika09/LearningRESTAPIs.git
```

2. Open the project in IntelliJ IDEA or your preferred Java IDE.

3. Configure your PostgreSQL database connection.

4. Run the Spring Boot application by executing:

```text
LearningRestapIsApplication.java
```

5. Access the APIs using Postman or another REST client:

```text
http://localhost:8080/api/students
```

## Future Improvements

- Add centralized exception handling using `@ControllerAdvice`.
- Add unit and integration tests for API endpoints.
- Implement pagination and sorting.
- Add API documentation using Swagger/OpenAPI.
- Implement authentication and authorization.

## Author

**Rutvika Lavangade**

GitHub: [rutvika09](https://github.com/rutvika09)
