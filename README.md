# Advanced API Development (AAD)

A practical, beginner-level backend project designed to demonstrate modern Advanced API Development (AAD) concepts. This project is built using **Java 21**, **Spring Boot**, **Spring Data JPA**, **Lombok**, and **MySQL**, managed via **Maven**. 

It showcases standard enterprise architectural patterns, automated database provisioning, and clean RESTful API endpoint management.

---

## 🛠️ Tech Stack & Ecosystem

| Technology | Artifact / Group ID | Version | Purpose |
| :--- | :--- | :--- | :--- |
| **Java 21** | — | `LTS` | Core programming language leveraging modern virtual threads and features. |
| **Spring Boot** | `spring-boot-starter-parent` | `4.0.6` | Framework foundation for rapid, production-ready backend development. |
| **Spring Web MVC** | `spring-boot-starter-webmvc` | *Managed* | Standard MVC architecture for handling incoming HTTP REST requests. |
| **Spring Data JPA**| `spring-boot-starter-data-jpa` | *Managed* | Object-Relational Mapping (ORM) via Hibernate for database interaction. |
| **Lombok** | `org.projectlombok:lombok` | *Managed* | Minimizes boilerplate code (Getters, Setters, Constructors) via compile-time processors. |
| **MySQL Connector**| `mysql:mysql-connector-java` | `8.0.33` | Database driver enabling application connectivity to the MySQL instance. |
| **Maven** | — | `3.x` | Build automation, dependency management, and compilation lifecycle. |

---

## ⚙️ Configuration Profile

The application comes pre-configured to automatically manage its lifecycle and database setup. Below are the properties defined in `src/main/resources/application.properties`:

```properties
# Application Meta
spring.application.name=aad

# Database Connection (Automated Schema Creation Enabled)
spring.datasource.url=jdbc:mysql://localhost:3306/aad?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=mysql

# JPA & Hibernate Properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```

---

## 🏗️ Architectural Pattern & Project Structure

The project strictly follows the **Layered Architecture Pattern** (Controller-Service-Repository), separating concerns across individual domains (`User` and `Department`) to ensure high maintainability, scalability, and loose coupling.

```text
lk.ijse.aad
 ├── controller      # REST Controllers (Handles HTTP Request/Response mapping)
 ├── dto             # Data Transfer Objects (Safe data propagation between layers)
 ├── entity          # JPA Entities (Database Tables mapped to Java Objects)
 ├── enums           # Domain Specific Enumerations (e.g., UserStatus)
 ├── repository      # Data Access Layer (Spring Data JPA Repositories)
 └── service         # Business Logic Layer (Interfaces & Implementations)

```

### Key Design Implementations:

* **Decoupled Data Flow:** Implemented distinct DTO layers (`UserDTO`, `DepartmentDTO`) to decouple internal database structures from client-facing API response objects.
* **JPA Lifecycle Management:** Leveraged Hibernate's `update` routine to automatically generate schemas and keep tracking records synchronized via physical primary key indexing.

---

## 🚀 API Testing & Industry Standard Tooling

Instead of relying on heavy, external graphical user interfaces, this project utilizes the **IntelliJ HTTP Client** ecosystem (`.http` scripting). This is an industry-standard approach that allows API specifications, testing scripts, and sample network payloads to be managed completely under version control (Git) right alongside the application codebase.

### Test Script Directory Location

The test scripts are natively stored inside the build resource context path:

* 📂 `src/main/resources/user-api.http` — Tracks execution for saving, listing, and querying users.
* 📂 `src/main/resources/department-api.http` — Tracks department schema saving, listing, and querying.

### Execution Blueprint Sample (`.http`)

```http
### Save a New User Record (POST)
POST http://localhost:8080/v1/users
Content-Type: application/json

{
  "firstName": "Natasha",
  "lastName": "Perera",
  "dob": "2002-05-30",
  "status": "ACTIVE"
}

### Query Resource by Unique ID (GET using Query Params)
GET http://localhost:8080/v1/users/userId?id=3
Accept: application/json

```

---

## 💻 Execution & Deployment Workflow

1. Ensure a local **MySQL** instance is running on port `3306`.
2. Boot up the Spring Boot application using your IDE or terminal:
```bash
mvn spring-boot:run

```


3. Open the `.http` files inside IntelliJ and select the green **Play** icons located in the gutter to live-test endpoints and witness real-time JSON payloads.

```

```
