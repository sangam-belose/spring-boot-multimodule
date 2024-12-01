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

- [JDK 17+](https://adoptopenjdk.net/)
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
src/
├── main/
│   ├── kotlin/          # Kotlin source files
│   │   └── com/wranto/spring_boot_multimodule  # Your package structure
│   ├── resources/
│       ├── application.yml    # Default configuration
│       ├── application-local.yml # Local configuration (optional)
│       └── db/migration/      # Flyway/Liquibase scripts (if any)
└── test/
├── kotlin/com/wranto/spring_boot_multimodule    
    ├── integrationTest      # Integration Test
    ├── service              # Unit test
└── resources/             # Test resources


