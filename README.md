# WalletService

**WalletService** is a Spring Boot application designed to manage virtual wallets for users, allowing functionalities such as balance inquiry, deposits, withdrawals, and transaction history.

---

## **Features**

### 1. Wallet Management
- Create a new wallet for a user.
- View the current balance of a wallet.
- Deposit funds into a wallet.
- Withdraw funds from a wallet, with validation for insufficient balance.

### 2. Transaction Logging
- Each operation (deposit, withdrawal) is logged as a transaction.
  - Includes wallet ID, transaction type, amount, and timestamp.

### 3. Error Handling
- `WalletNotFoundException`: Thrown when a requested wallet is not found.
- `InsufficientFundsException`: Thrown when attempting to withdraw more funds than available.

---

## **Endpoints**

### 1. Create Wallet
- **URL**: `POST /wallet`
- **Request Body**:
  ```json
  {
    "userId": "user123"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "userId": "user123",
    "balance": 0.0,
    "createdAt": "2023-12-13T10:00:00"
  }
  ```

### 2. Get Wallet Balance
- **URL**: `GET /wallet/{id}/balance`
- **Response**:
  ```json
  100.0
  ```

### 3. Deposit Funds
- **URL**: `POST /wallet/{id}/deposit?amount=100`
- **Response**:
  ```json
  {
    "id": 1,
    "userId": "user123",
    "balance": 150.0,
    "createdAt": "2023-12-13T10:00:00"
  }
  ```

### 4. Withdraw Funds
- **URL**: `POST /wallet/{id}/withdraw?amount=50`
- **Response**:
  ```json
  {
    "id": 1,
    "userId": "user123",
    "balance": 50.0,
    "createdAt": "2023-12-13T10:00:00"
  }
  ```

---

## **Technologies Used**

- **Spring Boot**: Framework for building the application.
- **H2 Database**: In-memory database for development and testing.
- **JPA (Hibernate)**: ORM for managing entities.
- **JUnit 5 & Mockito**: For unit and integration testing.
- **Maven**: Build and dependency management.

---

## **Setup Instructions**

### Prerequisites
- Java 17+
- Maven 3.6+

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/WalletService.git
   cd WalletService
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access the application at:
   ```
   http://localhost:8080
   ```

---

## **Testing**

### Run Unit Tests
To execute the test suite:
```bash
mvn test
```

### Example Test Cases
- Validate wallet creation.
- Ensure balance inquiries return correct values.
- Test deposit and withdrawal operations, including edge cases (e.g., insufficient funds).

---

## **Project Structure**
```
WalletService/
├── src/
│   ├── main/
│   │   ├── java/com/walletservice/
│   │   │   ├── WalletServiceApplication.java
│   │   │   ├── controller/WalletController.java
│   │   │   ├── exception/
│   │   │   │   ├── InsufficientFundsException.java
│   │   │   │   └── WalletNotFoundException.java
│   │   │   ├── model/
│   │   │   │   ├── Wallet.java
│   │   │   │   └── Transaction.java
│   │   │   ├── repository/
│   │   │   │   ├── WalletRepository.java
│   │   │   │   └── TransactionRepository.java
│   │   │   └── service/WalletService.java
│   ├── resources/application.properties
│
├── pom.xml
└── README.md
```

---

## **Contributing**
1. Fork the repository.
2. Create a new branch for your feature:
   ```bash
   git checkout -b feature/new-feature
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add new feature"
   ```
4. Push to your branch:
   ```bash
   git push origin feature/new-feature
   ```
5. Create a Pull Request.

---

## **License**
This project is licensed under the MIT License.

