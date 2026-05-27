# Midas Core – FinTech Transaction Processing System

## Overview

Midas Core is a Spring Boot based backend application designed to simulate a financial transaction processing system. The project integrates Apache Kafka for asynchronous transaction processing, H2 Database for persistence, REST APIs for balance querying, and an external Incentive API for reward calculations.

The application validates incoming transactions, updates user balances, stores transaction records, and exposes APIs for retrieving account balances.

---

# Features

- Apache Kafka integration for asynchronous transaction handling
- Transaction validation and processing
- H2 in-memory database integration
- Spring Data JPA entity management
- Incentive API integration
- REST API for balance queries
- Automated testing using Spring Boot Test and Embedded Kafka
- Maven-based build and dependency management

---

# Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Core programming language |
| Spring Boot | Backend framework |
| Apache Kafka | Message broker |
| Spring Kafka | Kafka integration |
| Spring Data JPA | Database ORM |
| H2 Database | In-memory relational database |
| Maven | Build and dependency management |
| REST APIs | Service communication |
| Git & GitHub | Version control |

---

# Project Structure

```text
forage-midas/
│
├── services/
│   └── transaction-incentive-api.jar
│
├── src/
│   ├── main/
│   │   └── java/com/jpmc/midascore/
│   │       │
│   │       ├── component/
│   │       │   ├── DatabaseConduit.java
│   │       │   └── TransactionListener.java
│   │       │
│   │       ├── controller/
│   │       │   └── BalanceController.java
│   │       │
│   │       ├── entity/
│   │       │   ├── UserRecord.java
│   │       │   └── TransactionRecord.java
│   │       │
│   │       ├── foundation/
│   │       │   ├── Transaction.java
│   │       │   ├── Balance.java
│   │       │   └── Incentive.java
│   │       │
│   │       ├── repository/
│   │       │   ├── UserRepository.java
│   │       │   └── TransactionRepository.java
│   │       │
│   │       └── MidasCoreApplication.java
│   │
│   └── test/
│       └── java/com/jpmc/midascore/
│           ├── TaskOneTests.java
│           ├── TaskTwoTests.java
│           ├── TaskThreeTests.java
│           ├── TaskFourTests.java
│           └── TaskFiveTests.java
│
├── application.yml
├── pom.xml
└── README.md
```

---

# System Workflow

## 1. Kafka Transaction Processing

Incoming financial transactions are received through Apache Kafka.

The Kafka listener:
- Consumes transaction messages
- Deserializes JSON payloads
- Validates transactions
- Processes balance updates

---

## 2. Transaction Validation

Each transaction is validated using the following conditions:

- Sender account must exist
- Recipient account must exist
- Sender must have sufficient balance

Invalid transactions are discarded.

---

## 3. Database Persistence

Valid transactions are stored in the H2 database using Spring Data JPA.

The application maintains:
- User records
- Transaction records
- Incentive amounts
- Updated balances

---

## 4. Incentive API Integration

After validation, transactions are sent to the external Incentive API.

The API:
- Calculates incentive amounts
- Returns incentive rewards
- Adds rewards to recipient balances

---

## 5. Balance REST API

The application exposes a REST endpoint:

```http
GET /balance?userId={id}
```

The API returns:
- User balance in JSON format
- Balance `0` if the user does not exist

The application runs on port:

```text
33400
```

---

# Setup Instructions

## Clone Repository

```bash
git clone https://github.com/your-username/forage-midas.git
cd forage-midas
```

---

# Configure Java

Verify Java installation:

```bash
java -version
javac -version
```

This project requires:
- Java 17

---

# Build Project

```bash
./mvnw clean compile
```

---

# Run Incentive API

```bash
java -jar services/transaction-incentive-api.jar
```

---

# Run Application

```bash
./mvnw spring-boot:run
```

---

# Execute Tests

Run all tests:

```bash
./mvnw test
```

Run specific test:

```bash
./mvnw -Dtest=TaskFiveTests test
```

---

# REST API Example

## Request

```http
GET http://localhost:33400/balance?userId=1
```

## Response

```json
{
  "amount": 1326.98
}
```

---

# Key Learnings

This project provided practical experience with:

- Spring Boot backend development
- Apache Kafka integration
- Asynchronous transaction processing
- REST API development
- Spring Data JPA
- Database persistence
- External API communication
- Maven build management
- Git and GitHub workflows
- Debugging distributed backend systems

---

# Challenges Faced

Some major issues resolved during development:

- Kafka serialization/deserialization configuration
- Spring Boot dependency setup
- JPA entity relationships
- Optional handling in repositories
- REST API integration
- GitHub authentication using PAT
- WSL and PowerShell environment conflicts

---

# Future Improvements

Possible enhancements include:

- PostgreSQL/MySQL integration
- Docker containerization
- Swagger/OpenAPI documentation
- JWT authentication
- Improved exception handling
- Service layer architecture
- Logging and monitoring
- Unit and integration test coverage

---

# Author

**Uday Reddy**

GitHub Repository:  
https://github.com/udayreddyvangala499-collab/forage-midas
