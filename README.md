# NetMirror 🎬

NetMirror is a Spring Boot REST API project built to learn backend development fundamentals. The project currently provides movie watchlist management features using in-memory storage and follows a layered architecture with Controllers, Services, Models, Validation, and Global Exception Handling.

## Features

### Movie Management

* Add a movie
* Get all movies
* Get a movie by ID
* Update movie details
* Delete a movie

### Validation

* Prevent empty movie titles
* Prevent empty movie genres

### Exception Handling

* Custom `MovieNotFoundException`
* Global exception handling using `@RestControllerAdvice`

## Tech Stack

* Java
* Spring Boot
* Maven
* IntelliJ IDEA
* Postman

## Project Structure

```text
src/main/java/com/jeel/netmirror

├── controller
│   └── MovieController
│
├── service
│   └── MovieService
│
├── model
│   └── Movie
│
├── exception
│   ├── MovieNotFoundException
│   └── GlobalExceptionHandler
│
└── NetMirrorApplication
```

## API Endpoints

### Get All Movies

```http
GET /api/movies
```

### Get Movie By ID

```http
GET /api/movies/{id}
```

### Add Movie

```http
POST /api/movies
```

Request Body:

```json
{
  "title": "Interstellar",
  "genre": "Sci-Fi",
  "watched": false,
  "watchLater": true
}
```

### Update Movie

```http
PUT /api/movies/{id}
```

Request Body:

```json
{
  "title": "Interstellar",
  "genre": "Adventure",
  "watched": true,
  "watchLater": false
}
```

### Delete Movie

```http
DELETE /api/movies/{id}
```

## Concepts Learned

### Spring Boot

* REST APIs
* Dependency Injection
* Controller Layer
* Service Layer
* Request Mapping
* ResponseEntity

### HTTP Methods

* GET
* POST
* PUT
* DELETE

### Validation

* `@Valid`
* `@NotBlank`

### Exception Handling

* Custom Exceptions
* Global Exception Handling

## Current Limitations

* No database integration
* Data is stored in memory using `ArrayList`
* Data is lost when application restarts
* No authentication or authorization
* No frontend integration

## Future Roadmap

### Phase 2

* OMDb API Integration
* Movie posters and ratings
* Search movies by title

### Phase 3

* MongoDB Integration
* Persistent storage

### Phase 4

* User Authentication
* Spring Security
* JWT Authentication

### Phase 5

* Watchlists
* Friend Recommendations
* Discussion Groups

### Phase 6

* React Frontend
* Full Stack Integration

## Author

Jeel Kanani

Learning Spring Boot through hands-on project development.
