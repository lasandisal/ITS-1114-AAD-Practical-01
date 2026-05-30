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
