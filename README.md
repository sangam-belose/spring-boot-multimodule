# Spring Boot Multimodule Microservice

A modern, Kotlin-based microservice built with Spring Boot. This service integrates with a PostgreSQL database and leverages Testcontainers for robust integration testing.

## Features

- **Spring Boot**: Rapid application development with the Spring framework.
- **Kotlin**: Concise and expressive language for modern JVM applications.
- **PostgreSQL**: Reliable and powerful relational database.
- **Testcontainers**: Seamless and reusable Docker-based integration testing.

---

## Prerequisites

Before running the application, ensure you have the following installed:

- [JDK 21+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/) (for dependency management)
- [Docker](https://www.docker.com/) (for Testcontainers)

---

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/sangam-belose/spring-boot-multimodule.git
cd your-repo-name
```

### Build the project

```bash
mvn clean install
```

### Running the Application

```bash
mvn spring-boot:run
```

## Testing
### Unit Tests

```bash
mvn test
```

### Integration Tests with Testcontainers

```bash
mvn verify
```

## Code Structure
```
src/
├── main/
│   ├── kotlin/
│   │   └── com/wranto/spring_boot_multimodule  # Your main application package
│   │       ├── config/            # Configuration classes
│   │       ├── controller/        # REST/GraphQL controllers
│   │       ├── service/           # Business logic services
│   │       ├── repository/        # JPA repositories
│   │       └── domain/            # Domain models/entities
│   ├── resources/
│       ├── application.properties        # Default configuration
│       ├── application-integration.properties  # Integration test environment configuration (optional)
│       └── db/
│           └── migration/         # Flyway/Liquibase migration scripts
├── test/
│   ├── kotlin/
│   │   └── com/wranto/spring_boot_multimodule
│   │       ├── integrationTest/   # Integration tests
│   │       └── service/           # Unit tests
│   └── resources/                 # Test-specific resources

```
