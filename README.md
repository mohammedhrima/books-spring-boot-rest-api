# Books REST API 📚

A RESTful API for managing a book collection built with Spring Boot. Perform CRUD operations on books with a clean, well-structured backend architecture.

## 🎯 What Does It Do?

This API provides a complete backend solution for managing books in a library or bookstore system. You can:

- **Create Books**: Add new books to the collection with details like title, author, ISBN, price, and publication date
- **Read Books**: Retrieve all books or find specific books by ID
- **Update Books**: Modify existing book information
- **Delete Books**: Remove books from the collection
- **Search & Filter**: Find books by various criteria (coming soon)

## 👤 Who Is It For?

- Backend developers learning Spring Boot
- Students building full-stack applications
- Developers needing a book management system
- Anyone learning RESTful API design
- Teams building library or bookstore applications

## 🚀 How to Use

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Your favorite API testing tool (Postman, Insomnia, or curl)

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd books-spring-boot-rest-api
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The API will start on `http://localhost:8080`

### API Endpoints

#### Get All Books
```http
GET /api/books
```
Returns a list of all books in the collection.

**Response Example:**
```json
[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert C. Martin",
    "isbn": "978-0132350884",
    "price": 47.99,
    "publishedDate": "2008-08-01"
  }
]
```

#### Get Book by ID
```http
GET /api/books/{id}
```
Returns a specific book by its ID.

**Response Example:**
```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884",
  "price": 47.99,
  "publishedDate": "2008-08-01"
}
```

#### Create a New Book
```http
POST /api/books
Content-Type: application/json
```

**Request Body:**
```json
{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "978-0134685991",
  "price": 54.99,
  "publishedDate": "2018-01-06"
}
```

**Response:** Returns the created book with its assigned ID.

#### Update a Book
```http
PUT /api/books/{id}
Content-Type: application/json
```

**Request Body:**
```json
{
  "title": "Effective Java (3rd Edition)",
  "author": "Joshua Bloch",
  "isbn": "978-0134685991",
  "price": 49.99,
  "publishedDate": "2018-01-06"
}
```

**Response:** Returns the updated book.

#### Delete a Book
```http
DELETE /api/books/{id}
```
Removes the book with the specified ID.

**Response:** 204 No Content on success.

### Testing with curl

```bash
# Get all books
curl http://localhost:8080/api/books

# Get book by ID
curl http://localhost:8080/api/books/1

# Create a new book
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Spring in Action",
    "author": "Craig Walls",
    "isbn": "978-1617294945",
    "price": 44.99,
    "publishedDate": "2018-10-03"
  }'

# Update a book
curl -X PUT http://localhost:8080/api/books/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Updated Title",
    "author": "Updated Author",
    "isbn": "978-1234567890",
    "price": 39.99,
    "publishedDate": "2024-01-01"
  }'

# Delete a book
curl -X DELETE http://localhost:8080/api/books/1
```

## 🛠️ Technical Stack

- **Spring Boot 4.0.1**: Modern Java framework for building web applications
- **Spring Web MVC**: RESTful web services
- **Spring Data JPA**: Database access and ORM
- **H2 Database**: In-memory database for development and testing
- **Maven**: Dependency management and build tool
- **Java 17**: Programming language

## 📁 Project Architecture

```
books-spring-boot-rest-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/restapi/
│   │   │       ├── model/          # Book entity (database table)
│   │   │       ├── controller/     # REST endpoints
│   │   │       ├── service/        # Business logic
│   │   │       └── repository/     # Database operations
│   │   └── resources/
│   │       └── application.properties  # Configuration
│   └── test/                       # Unit and integration tests
└── pom.xml                         # Maven dependencies
```

### Architecture Layers

1. **Model Layer**: Defines the Book entity with JPA annotations
2. **Repository Layer**: Handles database operations using Spring Data JPA
3. **Service Layer**: Contains business logic and validation
4. **Controller Layer**: Exposes REST endpoints and handles HTTP requests/responses

## 🔧 Configuration

### Database Configuration

The application uses H2 in-memory database by default. To view the database console:

1. Access `http://localhost:8080/h2-console`
2. Use JDBC URL: `jdbc:h2:mem:testdb`
3. Username: `sa`
4. Password: (leave empty)

### Application Properties

Edit `src/main/resources/application.properties`:

```properties
# Server port
server.port=8080

# H2 Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# H2 Console
spring.h2.console.enabled=true
```

## 📊 Data Model

### Book Entity

| Field | Type | Description |
|-------|------|-------------|
| id | Long | Primary key (auto-generated) |
| title | String | Book title |
| author | String | Author name |
| isbn | String | ISBN number |
| price | Double | Book price |
| publishedDate | LocalDate | Publication date |

## 🧪 Testing

Run tests with Maven:

```bash
mvn test
```

The project includes:
- Unit tests for service layer
- Integration tests for REST endpoints
- Repository tests for database operations

## 🚀 Deployment

### Build for Production

```bash
mvn clean package
```

This creates a JAR file in the `target/` directory.

### Run the JAR

```bash
java -jar target/rest-api-0.0.1-SNAPSHOT.jar
```

### Docker Deployment (Optional)

Create a `Dockerfile`:

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/rest-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

Build and run:

```bash
docker build -t books-api .
docker run -p 8080:8080 books-api
```

## 🔐 Security (Coming Soon)

Future enhancements:
- Spring Security integration
- JWT authentication
- Role-based access control
- API rate limiting

## 📈 Future Enhancements

- [ ] Search books by title, author, or ISBN
- [ ] Pagination and sorting
- [ ] Book categories and tags
- [ ] User reviews and ratings
- [ ] Book cover image upload
- [ ] Integration with external book APIs
- [ ] MySQL/PostgreSQL support
- [ ] API documentation with Swagger/OpenAPI

## 🤝 Contributing

Contributions are welcome! This is a great project for learning Spring Boot.

## 📄 License

This project is open source and available for educational purposes.