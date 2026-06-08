# books-spring-boot-rest-api

A small REST API for managing books, built with Spring Boot and Spring Data JPA on an
in-memory H2 database.

## Run

```bash
./mvnw spring-boot:run
```

Starts on http://localhost:8080 (H2 console at `/h2-console`).

## Endpoints

- `GET    /api/books` — list all books
- `POST   /api/books` — create a book
- `GET    /api/books/{id}` — get one book
- `DELETE /api/books/{id}` — delete a book
