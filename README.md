
## Bookstore Management API

A simple yet functional bookstore management system built using **Spring Boot**, **Kotlin**, and **PostgreSQL**. It supports CRUD operations for managing `Authors` and `Books`, where each book is linked to a single author and each author can have multiple books.

---

## Features

- Create, Read, Update (Full/Patch), and Delete Authors and Books
- Filter books by author ID
- RESTful API design with appropriate HTTP status codes
- Clean DTO-to-entity mapping using Kotlin extension functions

---

## Tech Stack

- **Language:** Kotlin  
- **Backend:** Spring Boot  
- **Database:** PostgreSQL (via Docker)  
- **DB Management:** Adminer  
- **Build Tool:** Maven  
- **Architecture:** RESTful APIs, DTO-based design

---

## API Endpoints

### Books (`/v1/books`)
| Method | Endpoint           | Description                                 |
|--------|--------------------|---------------------------------------------|
| `GET`  | `/v1/books`        | List all books (optionally by `author` ID)  |
| `GET`  | `/v1/books/{isbn}` | Get a book by ISBN                          |
| `PUT`  | `/v1/books/{isbn}` | Create or replace a book                    |
| `PATCH`| `/v1/books/{isbn}` | Partially update book details               |
| `DELETE`| `/v1/books/{isbn}`| Delete a book by ISBN                       |

### Authors (`/v1/authors`)
| Method | Endpoint              | Description                   |
|--------|-----------------------|-------------------------------|
| `GET`  | `/v1/authors`         | List all authors              |
| `GET`  | `/v1/authors/{id}`    | Get author by ID              |
| `POST` | `/v1/authors`         | Create a new author           |
| `PUT`  | `/v1/authors/{id}`    | Full update of an author      |
| `PATCH`| `/v1/authors/{id}`    | Partial update of an author   |
| `DELETE`| `/v1/authors/{id}`   | Delete an author by ID        |

---

## How to Run

1. **Clone the repo:**
   ```bash
   git clone https://github.com/ZRishu/bookstore-backend.git
   cd bookstore-api
   ```

2. **Configure environment:**

   - Copy the example env file and set your values:
     ```bash
     cp .env.example .env
     ```

3. **Start services with Docker Compose:**
   ```bash
   docker compose up -d
   ```

4. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

---

## Project Structure

```
src/main/kotlin/org/zr/bookstore
├── controllers/        # REST controllers
├── domain/
│   ├── dtos/           # DTOs for requests and responses
│   ├── entities/       # JPA entities
├── services/           # Business logic layer
├── repositories/       # Spring Data JPA interfaces
├── exceptions/         # Custom exception classes
├── BookstoreApplication.kt  # Main application entry point
├── Extensions.kt            # DTO ↔ Entity mapping functions
```

---

## Future Improvements

- Add test coverage for services and controllers
